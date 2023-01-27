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

import java.util.List;

public class Student {

  private int id;
  private String name;
  private List<Marks> marks;

  public Student() {
    // Default contructor for deserialization
  }

  public Student(final int id, final String name, final List<Marks> marks) {
    this.id = id;
    this.name = name;
    this.marks = marks;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Marks> getMarks() {
    return List.copyOf(marks);
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", scores=" + marks +
        '}';
  }
}