package com.poccleanarch.external.repository;

import com.poccleanarch.business.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepository implements
    com.poccleanarch.business.gateway.repository.ImageRepository {

  private static final String COLLECTION_NAME = "Image";
  private static final String ID = "id";
  private static final Logger LOGGER = LoggerFactory.getLogger(ImageRepository.class);

  private final MongoTemplate mongoTemplate;

  public ImageRepository(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Image createImage(Image image) {
    return mongoTemplate.save(image, COLLECTION_NAME);
  }

  @Override
  public Image findImagesById(String id) {
    return mongoTemplate.findById(id, Image.class);
  }

  @Override
  public void deleteImage(String id) {
    Query query = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(query, Image.class);
  }
}
