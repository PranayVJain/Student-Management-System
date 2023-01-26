/*
 * #%L
 * studentmanager
 *
 * %%
 * Copyright (C) 2018 - 2022 Nuance Communications Inc. All Rights Reserved.
 * %%
 *
 * The copyright to the computer program(s) herein is the property of
 * Nuance Communications Inc. The program(s) may be used and/or copied
 * only with the written permission from Nuance Communications Inc.
 * or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program(s) have been supplied.
 * #L%
 */
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