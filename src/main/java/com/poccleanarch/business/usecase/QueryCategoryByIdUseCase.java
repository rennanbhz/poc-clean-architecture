package com.poccleanarch.business.usecase;

import com.poccleanarch.business.model.Category;
import com.poccleanarch.business.gateway.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QueryCategoryByIdUseCase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(QueryCategoryByIdUseCase.class);

  private final CategoryRepository categoryRepository;

  public QueryCategoryByIdUseCase(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category execute(String id) {
    LOGGER.debug("Started GetCategoryUseCase.execute");
    return categoryRepository.findCategoryById(id);
  }
}
