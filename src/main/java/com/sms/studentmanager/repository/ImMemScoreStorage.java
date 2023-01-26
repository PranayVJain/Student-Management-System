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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class ImMemScoreStorage implements ScoreRepository {

  private final Map<Integer, Score> scoreMap = new ConcurrentHashMap<>();

  @Override
  public void saveScore(final Score score) {
    scoreMap.put(score.getStudentId(), score);
  }

  @Override
  public List<Score> getAllScores() {
    return new ArrayList<>(scoreMap.values());
  }

}