package com.poccleanarch.business.exception;

import com.poccleanarch.entrypoint.graphql.exception.ErrorType;
import com.poccleanarch.entrypoint.graphql.exception.GlobalException;
import com.poccleanarch.entrypoint.graphql.exception.Issue;
import com.poccleanarch.entrypoint.graphql.exception.IssueEnum;

public class BusinessValidationException extends GlobalException {

  private static final long serialVersionUID = 1L;

  private BusinessValidationException(final ErrorType errorType, final Issue issue) {
    super(errorType.getType(), issue);
  }

  public static BusinessValidationException businessException(
      final ErrorType errorType, final IssueEnum issueEnum, final String name) {
    return new BusinessValidationException(errorType, new Issue(issueEnum, name));
  }

  public static BusinessValidationException businessException(
      final IssueEnum issueEnum, final String name) {
    return new BusinessValidationException(ErrorType.VALIDATION_ERROR, new Issue(issueEnum, name));
  }

  public static BusinessValidationException businessException(
      final ErrorType errorType, final IssueEnum issueEnum) {
    return new BusinessValidationException(errorType, new Issue(issueEnum));
  }

  public static BusinessValidationException businessException(final IssueEnum issueEnum) {
    return new BusinessValidationException(ErrorType.VALIDATION_ERROR, new Issue(issueEnum));
  }

  public static BusinessValidationException businessException(
      final IssueEnum issueEnum, final Object... args) {
    return new BusinessValidationException(ErrorType.VALIDATION_ERROR, new Issue(issueEnum, args));
  }
}
