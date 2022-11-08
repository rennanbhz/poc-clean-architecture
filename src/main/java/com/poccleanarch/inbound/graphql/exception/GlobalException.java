package com.poccleanarch.inbound.graphql.exception;

public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 3226753888682202000L;
  private final Issue issue;

  public GlobalException(final String message, final Issue issue) {
    super(message);
    this.issue = issue;
  }

  public Issue getIssue() {
    return issue;
  }
}
