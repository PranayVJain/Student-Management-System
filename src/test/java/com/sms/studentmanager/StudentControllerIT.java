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
package com.sms.studentmanager;

import static com.sms.studentmanager.ResponseBodyMatchers.responseBody;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sms.studentmanager.controller.StudentController;
import com.sms.studentmanager.exception.StudentNotFoundException;
import com.sms.studentmanager.model.Marks;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.model.Subject;
import com.sms.studentmanager.service.StudentService;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = StudentController.class)
public class StudentControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  @Test
  public void ifValidInputThenCreateStudent() throws Exception {
    String student = "{\"name\":\"Pranay1\",\"marks\":[{\"subject\":\"MATH\",\"marks\":40},{\"subject\":\"ENGLISH\",\"marks\":45}]}";
    Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn(new Random().nextInt());
    mockMvc.perform(post("/v1/students")
        .contentType("application/json")
        .content(student)
    ).andExpect(status().is(HttpStatus.CREATED.value()));
  }

  @Test
  public void ifValidInputThenGetStudent() throws Exception {
    final int studentId = 1;
    final Student expected = new Student(1, "TestStudent", List.of(new Marks(40, Subject.ENGLISH)));
    Mockito.when(studentService.getStudent(studentId)).thenReturn(expected);
    mockMvc.perform(get("/v1/students/1"))
        .andExpect(status().isOk())
        .andExpect(responseBody().containsObjectAsJson(expected, Student.class));
  }

  @Test
  public void ifInvalidStudentIdInputThenGetStudentNotFound() throws Exception {
    final int studentId = 1;
    Mockito.when(studentService.getStudent(studentId)).thenThrow(new StudentNotFoundException("Student not found"));
    mockMvc.perform(get("/v1/students/1"))
        .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
  }

  @Test
  public void ifValidInputThenGetStudents() throws Exception {
    final Student student1 = new Student(1, "TestStudent", List.of(new Marks(40, Subject.ENGLISH)));
    final Student student2 = new Student(2, "TestStudent", List.of(new Marks(40, Subject.ENGLISH)));
    Mockito.when(studentService.getAllStudent()).thenReturn(List.of(student1, student2));
    mockMvc.perform(get("/v1/students"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void ifInvalidInputThenBadRequest() throws Exception {
    String student = "{\"name\":\"Pranay1\",\"marks\":[{\"subject\":\"MATH1\",\"marks\":40},{\"subject\":\"ENGLISH\",\"marks\":45}]}";
    mockMvc.perform(post("/v1/students")
        .contentType("application/json")
        .content(student)
    ).andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
  }

  @Test
  public void ifInvalidURLThenResourceNotFound() throws Exception {
    String student = "{\"name\":\"Pranay1\",\"marks\":[{\"subject\":\"MATH\",\"marks\":40},{\"subject\":\"ENGLISH\",\"marks\":45}]}";
    mockMvc.perform(post("/v1/studentdata")
        .contentType("application/json")
        .content(student)
    ).andExpect(status().is(HttpStatus.NOT_FOUND.value()));
  }
}