package com.poccleanarch.entrypoint.graphql.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ErrorType {
  VALIDATION_ERROR("Validation Error"),
  CONTENT_NOT_FOUND_ERROR("Content not found");

  private final Logger logger = LogManager.getLogger(ErrorType.class);
  private final String type;

  ErrorType(final String type) {

    this.type = type;
  }

  public String getType() {

    return type;
  }
}
