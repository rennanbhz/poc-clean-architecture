package com.poccleanarch.business.gateway.validator;

import com.poccleanarch.business.exception.BusinessValidationException;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import com.poccleanarch.business.model.Category;
import com.poccleanarch.entrypoint.graphql.exception.ErrorType;
import com.poccleanarch.entrypoint.graphql.exception.IssueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DuplicatedCategoryValidator {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(DuplicatedCategoryValidator.class);

  private final CategoryRepository categoryRepository;

  public DuplicatedCategoryValidator(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }


  public void validate(Category category) {
    LOGGER.debug("Started DuplicatedCategoryValidator.validate");
    if (categoryRepository.hasDuplicated(category)) {
      LOGGER.error("There's already an category with the same name {}.", category.getName());
      throw BusinessValidationException.businessException(
          ErrorType.VALIDATION_ERROR, IssueEnum.CATEGORY_NAME_DUPLICATED);
    }
  }
}
