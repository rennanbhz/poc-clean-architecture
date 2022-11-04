package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Image;
import com.poccleanarch.business.gateway.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class GetImageUseCase {

  private final ImageRepository imageRepository;

  public GetImageUseCase(
      ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public Image execute(String id) {
    return imageRepository.findImagesById(id);
  }
}
