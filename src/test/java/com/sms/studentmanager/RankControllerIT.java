
package com.sms.studentmanager;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sms.studentmanager.controller.RankController;
import com.sms.studentmanager.exception.StudentNotFoundException;
import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.service.RankingService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = RankController.class)
public class RankControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RankingService rankingService;

  @Test
  public void ifValidInputThenGetRank() throws Exception {
    final int studentId = 1;
    final Rank expected = new Rank(1, studentId, 50);
    Mockito.when(rankingService.getRank(1)).thenReturn(expected);
    mockMvc.perform(get("/v1/ranks/students/1"))
        .andExpect(status().isOk())
        .andExpect(ResponseBodyMatchers.responseBody().containsObjectAsJson(expected, Rank.class));
  }

  @Test
  public void ifValidInputThenGetRanks() throws Exception {
    final int studentId = 1;
    final Rank rank1 = new Rank(1, studentId, 50);
    final Rank rank2 = new Rank(2, studentId, 50);
    Mockito.when(rankingService.getRanks(1, 3)).thenReturn(List.of(rank1, rank2));
    mockMvc.perform(get("/v1/ranks/students?from=1&to=3"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  public void ifInvalidStudentIdInputThenGetStudentNotFound() throws Exception {
    final int studentId = 1;
    Mockito.when(rankingService.getRank(studentId)).thenThrow(new StudentNotFoundException("Student not found"));
    mockMvc.perform(get("/v1/students/1"))
        .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
  }
}