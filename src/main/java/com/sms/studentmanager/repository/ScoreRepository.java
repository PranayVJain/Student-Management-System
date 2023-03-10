
package com.sms.studentmanager.repository;


import com.sms.studentmanager.model.Score;
import java.util.List;

public interface ScoreRepository {

  void saveScore(final Score score);

  List<Score> getAllScores();

}
