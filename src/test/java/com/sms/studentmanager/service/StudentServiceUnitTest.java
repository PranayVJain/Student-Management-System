
package com.sms.studentmanager.service;

import com.sms.studentmanager.model.Marks;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.model.Subject;
import com.sms.studentmanager.repository.ScoreRepository;
import com.sms.studentmanager.repository.StudentRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceUnitTest {

  @Mock
  private StudentRepository studentRepository;
  @Mock
  private KeyGenerator sequenceKeyGenerator;
  @Mock
  private ScoreRepository scoreRepository;

  private StudentService studentService;

  @BeforeEach
  public void init() {
    this.studentService = new StudentService(studentRepository, sequenceKeyGenerator, scoreRepository);
  }

  @Test
  public void ifSaveStudentThenGetStudentId() {
    Mockito.when(sequenceKeyGenerator.getNext()).thenReturn(1);
    Assertions.assertEquals(1, studentService.saveStudent(new Student(1, "Test", List.of())));
  }

  @Test
  public void ifGetStudentThenReturnStudent() {
    final int studentId = 1;
    final Student student = new Student(1, "TestStudent",
        List.of(new Marks(40, Subject.ENGLISH), new Marks(40.3f, Subject.MATH)));
    Mockito.when(studentRepository.getStudent(studentId)).thenReturn(student);
    Assertions.assertNotNull(studentService.getStudent(studentId));
  }
}