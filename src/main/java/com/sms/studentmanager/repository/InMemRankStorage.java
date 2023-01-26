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