package com.poccleanarch.business.controller;

import com.poccleanarch.business.controller.request.CategoryRequest;
import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.usecase.CreateCategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CreateCategoryController {

  private final CreateCategoryUseCase createCategoryUseCase;

  public CreateCategoryController(
      CreateCategoryUseCase createCategoryUseCase) {
    this.createCategoryUseCase = createCategoryUseCase;
  }

  @PostMapping(
      path = "/category",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Category> createCategory(Category category) {
    Category categoryRequest = createCategoryUseCase.execute(category);
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryRequest);
  }
}
