package com.poccleanarch.business.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Id;

public class CategoryRequest {

  @Id private String id;

  @JsonProperty
  private String name;

  @JsonProperty
  private String description;

  @JsonProperty
  private String helpText;

  public CategoryRequest(String name, String description, String helpText) {
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

  @Override
  public String toString() {
    return "CategoryRequest{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", helpText='" + helpText + '\'' +
        '}';
  }
}
