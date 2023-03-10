
package com.sms.studentmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerExceptionHandler {

  @ExceptionHandler(StudentNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorResponse studentNotFoundException(final StudentNotFoundException cause) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), cause.getMessage());
  }

  @ExceptionHandler(StudentAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public @ResponseBody ErrorResponse studentNotFoundException(final StudentAlreadyExistsException cause) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), cause.getMessage());
  }
}