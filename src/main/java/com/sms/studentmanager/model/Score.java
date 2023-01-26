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
package com.sms.studentmanager.model;

public class Score {

  private float marks;
  private Subject subject;

  public Score(final float marks, final Subject subject) {
    this.marks = marks;
    this.subject = subject;
  }

  public float getMarks() {
    return marks;
  }

  public Subject getSubject() {
    return subject;
  }

  @Override
  public String toString() {
    return "Score{" +
        "marks=" + marks +
        ", subject=" + subject +
        '}';
  }
}