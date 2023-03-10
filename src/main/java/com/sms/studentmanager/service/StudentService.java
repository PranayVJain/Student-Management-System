
package com.sms.studentmanager.service;

import com.sms.studentmanager.model.Marks;
import com.sms.studentmanager.model.Score;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.repository.ScoreRepository;
import com.sms.studentmanager.repository.StudentRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

  private final StudentRepository studentRepository;
  private final KeyGenerator sequenceKeyGenerator;
  private final ScoreRepository scoreRepository;

  public StudentService(final StudentRepository studentRepository,
      final KeyGenerator sequenceKeyGenerator,
      final ScoreRepository scoreRepository) {
    this.studentRepository = studentRepository;
    this.sequenceKeyGenerator = sequenceKeyGenerator;
    this.scoreRepository = scoreRepository;

  }

  public int saveStudent(final Student student) {
    LOGGER.info("Saving student {}", student);
    final int studentId = sequenceKeyGenerator.getNext();
    final float score = getScore(student);
    scoreRepository.saveScore(new Score(studentId, score));
    studentRepository.saveStudent(new Student(studentId, student.getName(), student.getMarks()));
    LOGGER.info("Saved student {} with id {}, score {}", student, studentId, score);
    return studentId;
  }

  private float getScore(final Student student) {
    return student
        .getMarks()
        .stream()
        .map(Marks::getMarks)
        .reduce(0f, Float::sum);
  }

  public Student getStudent(final int studentId) {
    return studentRepository.getStudent(studentId);
  }

  public List<Student> getAllStudent() {
    return studentRepository.getAllStudents();
  }
}