package com.poccleanarch.business.controller;

import com.poccleanarch.business.model.Image;
import com.poccleanarch.business.usecase.CreateImageUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CreateImageController {

  private final CreateImageUseCase createImageUseCase;

  public CreateImageController(
      CreateImageUseCase createImageUseCase) {
    this.createImageUseCase = createImageUseCase;
  }

  @PostMapping(
      path = "/image",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Image createImage(Image image) {
    return createImageUseCase.execute(image);
  }
}
