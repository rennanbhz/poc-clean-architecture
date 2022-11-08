package com.poccleanarch.entrypoint.graphql.exception;

import java.util.IllegalFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum IssueEnum {
  FIELD_NAME_ALREADY_EXISTS(1, "Field %s already registered"),
  INVALID_ID(2, "Invalid ID."),
  INVALID_ATTRIBUTE_VALUES(3, "Invalid value(s) on the enumValues."),
  CATEGORY_NAME_DUPLICATED(4, "Category name already exists."),
  CATEGORY_NOT_FOUND(5, "This Category doesn't exist");

  private final Logger logger = LogManager.getLogger(IssueEnum.class);
  private final int code;
  private final String message;

  IssueEnum(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getFormattedMessage(final Object... args) {

    if (message == null) {
      return "";
    }

    try {
      return String.format(message, args);
    } catch (final IllegalFormatException e) {
      logger.warn(e.getMessage(), e);
      return message.replace("%s", "");
    }
  }
}
