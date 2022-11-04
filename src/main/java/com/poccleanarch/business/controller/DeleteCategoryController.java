package com.poccleanarch.business.controller;

import com.poccleanarch.business.usecase.DeleteCategoryUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeleteCategoryController {

  private final DeleteCategoryUseCase deleteCategoryUseCase;

  public DeleteCategoryController(
      DeleteCategoryUseCase deleteCategoryUseCase) {
    this.deleteCategoryUseCase = deleteCategoryUseCase;
  }

  @DeleteMapping(path = "/{category_id}")
  public void deleteCategory(String id) {
    deleteCategoryUseCase.execute(id);
  }
}
