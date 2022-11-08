package com.poccleanarch.dataprovider.repository;

import com.poccleanarch.business.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements
    com.poccleanarch.business.gateway.repository.ProductRepository {

  private static final String COLLECTION_NAME = "Product";
  private static final String ID = "id";
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

  private final MongoTemplate mongoTemplate;

  public ProductRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Product createProduct(Product product) {
    LOGGER.debug("Started ProductRepository.createProduct");
    return mongoTemplate.save(product, COLLECTION_NAME);
  }

  @Override
  public Product findIProductById(String id) {
    LOGGER.debug("Started ProductRepository.findProductById");
    return mongoTemplate.findById(id, Product.class);
  }

  @Override
  public void deleteProduct(String id) {
    LOGGER.debug("Started ProductRepository.deleteProduct");
    Query query = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(query, Product.class);
  }
}
