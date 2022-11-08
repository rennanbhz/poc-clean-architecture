package com.poccleanarch.inbound.graphql.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty private int code;

  @JsonProperty private String message;

  @JsonProperty private List<String> details;

  @JsonIgnore private int httpStatus;

  @JsonIgnore private String content;

  public Issue() {}

  public Issue(final IssueEnum issue) {
    code = issue.getCode();
    message = issue.getFormattedMessage();
  }

  public Issue(final IssueEnum issue, final Object... args) {
    code = issue.getCode();
    message = issue.getFormattedMessage(args);
  }

  public Issue(final IssueEnum issue, final List<String> details) {
    this(issue);
    this.details = details;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public List<String> getDetails() {
    return details;
  }

  public int getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(int httpStatus) {
    this.httpStatus = httpStatus;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return String.format("Issue{code= %s, message='%s' details= '%s'}", code, message, details);
  }
}
