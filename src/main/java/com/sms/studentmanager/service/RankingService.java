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
package com.sms.studentmanager.service;

import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.repository.RankRepository;
import com.sms.studentmanager.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

  private final RankRepository rankRepository;
  private final StudentRepository studentRepository;

  public RankingService(final RankRepository rankRepository, final StudentRepository studentRepository) {
    this.rankRepository = rankRepository;
    this.studentRepository = studentRepository;
  }

  public List<Rank> calculateRank() {
    final List<Student> students = studentRepository.getAllStudents();
    return List.of();
  }

}