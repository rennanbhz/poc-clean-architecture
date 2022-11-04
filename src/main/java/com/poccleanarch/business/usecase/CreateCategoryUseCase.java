package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {

  private final CategoryRepository categoryRepository;

  public CreateCategoryUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category execute(Category category) {
    return categoryRepository.createCategory(category);
  }
}
