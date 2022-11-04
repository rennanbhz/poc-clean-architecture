package com.poccleanarch.business.controller;

import com.poccleanarch.business.model.Image;
import com.poccleanarch.business.usecase.GetImageUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GetImageController {

  private final GetImageUseCase getImageUseCase;

  public GetImageController(GetImageUseCase getImageUseCase) {
    this.getImageUseCase = getImageUseCase;
  }

  @GetMapping(path = "/{image_id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Image getImage(@PathVariable(name = "image_id") String imageId) {
    return getImageUseCase.execute(imageId);
  }
}
