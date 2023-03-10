
package com.sms.studentmanager.model;

public class Score {

  private final int studentId;
  private final float totalScore;

  public Score(final int studentId, final float totalScore) {
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