package com.poccleanarch.business.usecase;

import com.poccleanarch.business.gateway.validator.DuplicatedCategoryValidator;
import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CreateCategoryUseCase.class);

  private final CategoryRepository categoryRepository;
  private final DuplicatedCategoryValidator duplicatedCategoryValidator;

  public CreateCategoryUseCase(
      CategoryRepository categoryRepository,
      DuplicatedCategoryValidator duplicatedCategoryValidator) {
    this.categoryRepository = categoryRepository;
    this.duplicatedCategoryValidator = duplicatedCategoryValidator;
  }

  public Category execute(Category category) {
    LOGGER.debug("Started CreateCategoryUseCase.execute");
    duplicatedCategoryValidator.validate(category);
    return categoryRepository.createCategory(category);
  }
}
