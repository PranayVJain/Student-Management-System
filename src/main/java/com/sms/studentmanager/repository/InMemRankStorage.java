
package com.sms.studentmanager.repository;

import com.sms.studentmanager.model.Rank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemRankStorage implements RankRepository {

  private final List<Rank> rankList = new ArrayList<>();
  private final Map<Integer, Rank> rankMap = new ConcurrentHashMap<>();

  @Override
  public void saveRank(final Rank rank) {
    rankList.add(rank);
    rankMap.put(rank.getStudentId(), rank);
  }

  @Override
  public void clearRank() {
    rankList.clear();
    rankMap.clear();
  }

  @Override
  public Rank getRank(final int studentId) {
    return rankMap.get(studentId);
  }

  @Override
  public List<Rank> getRanks(int from, int to) {
    return rankList.subList(from - 1, Math.min(to, rankList.size()));
  }
}