
package com.sms.studentmanager.exception;

public class StudentAlreadyExistsException extends RuntimeException {

  private final String message;

  public StudentAlreadyExistsException(final String msg, final Throwable cause) {
    super(msg, cause);
    this.message = msg;
  }

  @Override
  public String getMessage() {
    return message;
  }
}