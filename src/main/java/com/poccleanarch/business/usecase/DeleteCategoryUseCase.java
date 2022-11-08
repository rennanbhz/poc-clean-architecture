package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(DeleteCategoryUseCase.class);

  private final CategoryRepository categoryRepository;

  public DeleteCategoryUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void execute(String id) {
    LOGGER.debug("Started DeleteCategoryUseCase.execute");
    categoryRepository.deleteCategory(id);
  }
}
