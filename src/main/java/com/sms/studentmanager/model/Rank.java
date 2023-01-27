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

public class Rank {

  private int rank;
  private int studentId;
  private float totalMarks;

  public Rank() {
  }

  public Rank(final int rank, final int studentId, final float totalMarks) {
    this.rank = rank;
    this.studentId = studentId;
    this.totalMarks = totalMarks;
  }

  public int getRank() {
    return rank;
  }

  public int getStudentId() {
    return studentId;
  }

  public float getTotalMarks() {
    return totalMarks;
  }

  @Override
  public String toString() {
    return "Rank{" +
        "rank=" + rank +
        ", studentId=" + studentId +
        ", totalMarks=" + totalMarks +
        '}';
  }
}