package com.poccleanarch.business.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poccleanarch.business.model.Image;
import java.util.List;

public class ProductRequest {

  @JsonProperty
  String id;

  @JsonProperty
  String name;

  @JsonProperty
  String description;

  @JsonProperty
  String categoryId;

  @JsonProperty
  List<Image> images;

  public ProductRequest(String id, String name, String description, String categoryId,
      List<Image> images) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.images = images;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return "ProductRequest{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", categoryId='" + categoryId + '\'' +
        ", images=" + images +
        '}';
  }
}
