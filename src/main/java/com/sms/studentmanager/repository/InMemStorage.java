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
package com.sms.studentmanager.repository;

import com.sms.studentmanager.exception.StudentNotFoundException;
import com.sms.studentmanager.model.Student;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Repository;

@Repository
public class InMemStorage implements StudentRepository {

  private final Map<Integer, Student> inMemStore = new ConcurrentHashMap<>();
  private final AtomicInteger atomicInteger = new AtomicInteger();

  @Override
  public void saveStudent(final Student student) {
    inMemStore.put(student.getId(), student);
  }

  @Override
  public Student getStudent(final int id) {
    if(inMemStore.containsKey(id)){
      return inMemStore.get(id);
    }  else {
      throw new StudentNotFoundException("Student with id " + id + " does not exist");
    }
  }

  @Override
  public List<Student> getAllStudents() {
    return (List<Student>) inMemStore.values();
  }

  int getNextId() {
    return atomicInteger.incrementAndGet();
  }
}