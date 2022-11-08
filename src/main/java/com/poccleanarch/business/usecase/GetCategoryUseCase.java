package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(GetCategoryUseCase.class);

  private final CategoryRepository categoryRepository;

  public GetCategoryUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category execute(String id) {
    LOGGER.debug("Started GetCategoryUseCase.execute");
    return categoryRepository.findCategoryById(id);
  }
}
