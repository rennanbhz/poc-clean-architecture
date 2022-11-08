package com.poccleanarch.entrypoint.graphql.dto.input.product;

import static com.poccleanarch.crosscutting.InputMessagesValidation.MISSING_REQUIRED_VALUES;

import java.util.List;
import javax.validation.constraints.NotNull;

public class CreateProductInput {

  @NotNull(message = MISSING_REQUIRED_VALUES)
  private String name;

  @NotNull(message = MISSING_REQUIRED_VALUES)
  private String categoryId;

  @NotNull(message = MISSING_REQUIRED_VALUES)
  private String description;

  @NotNull(message = MISSING_REQUIRED_VALUES)
  private List<String> images;

  public CreateProductInput() {
  }

  public CreateProductInput(String name, String categoryId, String description,
      List<String> images) {
    this.name = name;
    this.categoryId = categoryId;
    this.description = description;
    this.images = images;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImage(List<String> images) {
    this.images = images;
  }
}
