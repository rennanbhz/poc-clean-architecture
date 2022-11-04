package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryUseCase {

  private final CategoryRepository categoryRepository;

  public GetCategoryUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category execute(String id) {
    return categoryRepository.findCategoryById(id);
  }
}
