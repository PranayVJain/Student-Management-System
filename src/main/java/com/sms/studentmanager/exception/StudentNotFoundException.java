
package com.sms.studentmanager.exception;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StudentNotFoundException extends RuntimeException {

  private final String message;

  public StudentNotFoundException(final String msg) {
    super(msg);
    this.message = msg;
  }

  @Override
  public String getMessage() {

    String s = ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT );

    return message;
  }
}