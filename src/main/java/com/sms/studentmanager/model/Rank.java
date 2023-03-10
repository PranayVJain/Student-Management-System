
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