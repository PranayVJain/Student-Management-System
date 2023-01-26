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

public class StudentScore {

  private final int studentId;
  private final float totalScore;

  public StudentScore(final int studentId, final float totalScore) {
    this.studentId = studentId;
    this.totalScore = totalScore;
  }

  public int getStudentId() {
    return studentId;
  }

  public float getTotalScore() {
    return totalScore;
  }

  @Override
  public String toString() {
    return "StudentScore{" +
        "studentId=" + studentId +
        ", totalScore=" + totalScore +
        '}';
  }
}