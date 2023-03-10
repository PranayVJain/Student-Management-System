
package com.sms.studentmanager.repository;

import com.sms.studentmanager.model.Student;
import java.util.List;

public interface StudentRepository {

  void saveStudent(Student student);

  Student getStudent(int id);

  List<Student> getAllStudents();
}
