package com.poccleanarch.business.controller;

import com.poccleanarch.business.usecase.DeleteImageUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeleteImageController {

  private final DeleteImageUseCase deleteImageUseCase;

  public DeleteImageController(
      DeleteImageUseCase deleteImageUseCase) {
    this.deleteImageUseCase = deleteImageUseCase;
  }

  @DeleteMapping(path = "/{image_id}")
  public void deleteImage(String id) {
    deleteImageUseCase.execute(id);
  }
}
