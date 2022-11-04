package com.poccleanarch.business.gateway.repository;

import com.poccleanarch.business.model.Image;

public interface ImageRepository {

  Image createImage(Image image);

  Image findImagesById(String Id);

  void deleteImage(String id);

}
