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

import com.sms.studentmanager.exception.StudentNotFoundException;
import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.model.Score;
import com.sms.studentmanager.repository.RankRepository;
import com.sms.studentmanager.repository.ScoreRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

  private final RankRepository rankRepository;
  private final ScoreRepository scoreRepository;

  public RankingService(final RankRepository rankRepository, final ScoreRepository scoreRepository) {
    this.rankRepository = rankRepository;
    this.scoreRepository = scoreRepository;
  }

  public void calculateRank() {
    final List<Score> scores = scoreRepository.getAllScores();
    final List<Score> scoreResult = scores.stream()
        .sorted((score1, score2) -> Float.compare(score2.getTotalScore(), score1.getTotalScore()))
        .collect(Collectors.toList());
    int rank = 1;
    rankRepository.clearRank();
    for (Score score : scoreResult) {
      rankRepository.saveRank(new Rank(rank++, score.getStudentId(), score.getTotalScore()));
    }
  }

  public Rank getRank(final int studentId) {
    final Rank rank = rankRepository.getRank(studentId);
    if (rank == null) {
      throw new StudentNotFoundException("Student with id " + studentId + " does not exist");
    }
    return rank;
  }

  public List<Rank> getRanks(final int from, final int to) {
    return rankRepository.getRanks(from, to);
  }
}