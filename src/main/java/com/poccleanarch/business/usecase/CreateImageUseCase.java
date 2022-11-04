package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Image;
import com.poccleanarch.business.gateway.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateImageUseCase {

  private final ImageRepository imageRepository;

  public CreateImageUseCase(
      ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public Image execute (Image image) {
    return imageRepository.createImage(image);
  }
}
