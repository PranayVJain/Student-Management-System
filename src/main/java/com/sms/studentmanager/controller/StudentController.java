
package com.sms.studentmanager.controller;

import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.service.StudentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
  private final StudentService studentService;

  public StudentController(final StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping
  public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    LOGGER.info("Received request to add student <{}>", student);
    final int studentId = studentService.saveStudent(student);
    LOGGER.info("Student added with id <{}>", studentId);
    return ResponseEntity.status(HttpStatus.CREATED).body(new Student(studentId, student.getName(), student.getMarks()));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<String> getStudent(@PathVariable("id") int studentId) {
    LOGGER.info("Received request to get student with id <{}>", studentId);
    final Student student = studentService.getStudent(studentId);
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Student>> getStudent() {
    LOGGER.info("Received request to get all students");
    return ResponseEntity.ok(studentService.getAllStudent());
  }

}