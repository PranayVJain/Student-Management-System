
package com.sms.studentmanager.repository;

import com.sms.studentmanager.model.Rank;
import java.util.List;

public interface RankRepository {

  void saveRank(Rank rank);

  void clearRank();

  Rank getRank(int studentId);

  List<Rank> getRanks(int from, int to);
}