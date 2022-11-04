package com.poccleanarch.external.repository;

import com.poccleanarch.business.model.Category;
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
    return mongoTemplate.save(category, COLLECTION_NAME);
  }

  @Override
  public Category findCategoryById(String id) {
    return mongoTemplate.findById(id, Category.class);
  }

  @Override
  public void deleteCategory(String id) {
    Query query = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(query, Category.class);
  }
}
