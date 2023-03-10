
package com.sms.studentmanager.repository;

import com.sms.studentmanager.model.Marks;
import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.model.Student;
import com.sms.studentmanager.model.Subject;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RankRepositoryIT {

  @Autowired
  private RankRepository rankRepository;

  @Test
  public void ifSaveRankThenPersist() {
    final Rank rank = new Rank(1, 1, 100);
    rankRepository.saveRank(rank);
    Assertions.assertEquals(1, rankRepository.getRank(1).getStudentId());
  }

  @Test
  public void ifGetRankThatDoesNotExistsThenReturnNull() {
    Assertions.assertNull(rankRepository.getRank(2));
  }
}