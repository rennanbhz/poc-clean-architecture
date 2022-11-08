package com.poccleanarch.outbound.repository;

import com.poccleanarch.business.exception.BusinessValidationException;
import com.poccleanarch.business.model.Category;
import com.poccleanarch.inbound.graphql.exception.ErrorType;
import com.poccleanarch.inbound.graphql.exception.IssueEnum;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository implements
    com.poccleanarch.business.gateway.repository.CategoryRepository {

  private static final String COLLECTION_NAME = "Category";
  private static final String ID = "id";
  private static final Logger LOGGER = LoggerFactory.getLogger(CategoryRepository.class);

  private final MongoTemplate mongoTemplate;

  public CategoryRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Category createCategory(Category category) {
    LOGGER.debug("Started CategoryRepository.createCategory");
    return mongoTemplate.save(category, COLLECTION_NAME);
  }

  @Override
  public Category findCategoryById(String id) {
    LOGGER.debug("Started CategoryRepository.findCategoryById");
    Category categoryResult = mongoTemplate.findById(id, Category.class);
    if(categoryResult != null) {
      return categoryResult;
    }
    throw BusinessValidationException.businessException(
        ErrorType.CONTENT_NOT_FOUND_ERROR, IssueEnum.CATEGORY_NOT_FOUND);
  }

  @Override
  public void deleteCategory(String id) {
    LOGGER.debug("Started CategoryRepository.DeleteCategory");
    Query query = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(query, Category.class);
  }

  @Override
  public boolean hasDuplicated(Category category) {
    Query query = Query.query(Criteria.where("name").is(category.getName()));
    Category categories = mongoTemplate.findOne(query, Category.class);
    return categories != null && Objects.equals(categories.getName(), category.getName());
  }
}
