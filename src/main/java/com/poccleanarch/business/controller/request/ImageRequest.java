package com.poccleanarch.business.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageRequest {

  @JsonProperty
  private String url;

  public ImageRequest(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "ImageRequest{" +
        "url='" + url + '\'' +
        '}';
  }
}
