
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