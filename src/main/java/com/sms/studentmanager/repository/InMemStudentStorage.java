package com.sms.studentmanager.repository;

import com.sms.studentmanager.exception.StudentNotFoundException;
import com.sms.studentmanager.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Repository;

@Repository
public class InMemStudentStorage implements StudentRepository {

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
    return new ArrayList<>(inMemStore.values());
  }

  int getNextId() {
    return atomicInteger.incrementAndGet();
  }
}