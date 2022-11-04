package com.poccleanarch.business.controller;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.usecase.GetCategoryUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GetCategoryController {

  private final GetCategoryUseCase getCategoryUseCase;

  public GetCategoryController(
      GetCategoryUseCase getCategoryUseCase) {
    this.getCategoryUseCase = getCategoryUseCase;
  }

  @GetMapping(path = "/{category_id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Category getCategory(@PathVariable(name = "category_id") String categoryId) {
    return getCategoryUseCase.execute(categoryId);
  }
}
