package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteImageUseCase {

  private final ImageRepository imageRepository;

  public DeleteImageUseCase(
      ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  public void execute(String id) {
    imageRepository.deleteImage(id);
  }
}
