package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryUseCase {

  private final CategoryRepository categoryRepository;

  public DeleteCategoryUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void execute(String id) {
    categoryRepository.deleteCategory(id);
  }
}
