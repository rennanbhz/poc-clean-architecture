package com.poccleanarch.inbound.graphql.dto.input.category;

import static com.poccleanarch.crosscutting.InputMessagesValidation.MAXIMUM_CHARACTER_LIMIT;
import static com.poccleanarch.crosscutting.InputMessagesValidation.MISSING_REQUIRED_VALUES;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CreateCategoryInput {

  @NotNull(message = MISSING_REQUIRED_VALUES)
  private String name;

  @NotNull(message = MISSING_REQUIRED_VALUES)
  @Length(max = 500, message = MAXIMUM_CHARACTER_LIMIT)
  private String description;

  @Length(max = 150, message = MAXIMUM_CHARACTER_LIMIT)
  private String helpText;

  public CreateCategoryInput() {}

  public CreateCategoryInput(String name, String description, String helpText) {
    this.name = name;
    this.description = description;
    this.helpText = helpText;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHelpText() {
    return helpText;
  }

  public void setHelpText(String helpText) {
    this.helpText = helpText;
  }
}
