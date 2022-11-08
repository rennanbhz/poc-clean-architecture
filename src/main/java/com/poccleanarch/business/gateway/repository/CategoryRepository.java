package com.poccleanarch.business.gateway.repository;

import com.poccleanarch.business.model.Category;

public interface CategoryRepository {

  Category createCategory(Category category);

  Category findCategoryById(String Id);

  void deleteCategory(String id);

  boolean hasDuplicated(Category category);

}
