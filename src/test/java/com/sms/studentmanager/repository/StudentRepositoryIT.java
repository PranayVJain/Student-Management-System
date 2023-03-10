
package com.sms.studentmanager.repository;

import com.sms.studentmanager.model.Marks;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.model.Subject;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryIT {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void ifSaveStudentThenPersist() {
    final Student student = new Student(1, "TestStudent", List.of(new Marks(10, Subject.ENGLISH)));
    studentRepository.saveStudent(student);
    Assertions.assertEquals("TestStudent", studentRepository.getStudent(1).getName());
  }

  @Test
  public void ifGetAllStudentsThenGetListOfStudents() {
    final Student student1 = new Student(1, "TestStudent", List.of(new Marks(10, Subject.ENGLISH)));
    final Student student2 = new Student(2, "TestStudent", List.of(new Marks(10, Subject.ENGLISH)));
    studentRepository.saveStudent(student1);
    studentRepository.saveStudent(student2);
    Assertions.assertEquals(2, studentRepository.getAllStudents().size());
  }
}