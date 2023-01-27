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

import com.sms.studentmanager.model.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreRepositoryIT {

  @Autowired
  private ScoreRepository scoreRepository;

  @Test
  public void ifSaveScoreThenPersist() {
    final Score score = new Score(1, 100);
    scoreRepository.saveScore(score);
    Assertions.assertEquals(1, scoreRepository.getAllScores().size());
  }

  @Test
  public void ifGetScoresThatDoesNotExistsThenReturnEmpty() {
    Assertions.assertEquals(0, scoreRepository.getAllScores().size());
  }
}