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
package com.sms.studentmanager.controller;

import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.repository.StudentRepository;
import com.sms.studentmanager.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(final StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping(value = "/v1/students", consumes = "application/json")
  public ResponseEntity addStudent(@RequestBody Student student) {
    final int studentId = studentService.saveStudent(student);
    return ResponseEntity.ok(studentId);
  }

  @GetMapping(value = "/v1/students/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId) {
    final Student student = studentService.getStudent(studentId);
    return ResponseEntity.ok(student);
  }

}