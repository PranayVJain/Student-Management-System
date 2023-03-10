
package com.sms.studentmanager.model;

import java.util.Objects;

public class Marks {

  private float marks;
  private Subject subject;

  public Marks(){
    // Default constructor
  }
  public Marks(final float marks, final Subject subject) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Marks)) {
      return false;
    }
    Marks marks1 = (Marks) o;
    return Float.compare(marks1.marks, marks) == 0 &&
        subject == marks1.subject;
  }

  @Override
  public int hashCode() {
    return Objects.hash(marks, subject);
  }

  @Override
  public String toString() {
    return "Score{" +
        "marks=" + marks +
        ", subject=" + subject +
        '}';
  }
}