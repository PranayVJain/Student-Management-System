package com.sms.studentmanager.controller;

import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.service.RankingService;
import com.sms.studentmanager.service.StudentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ranks")
public class RankController {

  private static final Logger LOGGER = LoggerFactory.getLogger(RankController.class);
  private final RankingService rankingService;

  public RankController(final RankingService rankingService) {
    this.rankingService = rankingService;
  }

  @PostMapping("/students")
  public ResponseEntity calculateRank() {
    LOGGER.info("Received request to calculate the rank of the students");
    rankingService.calculateRank();
    return ResponseEntity.ok().build();
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Rank> getRank(@PathVariable("id") int studentId) {
    LOGGER.info("Received request to get the rank of the student with id <{}>", studentId);
    return ResponseEntity.ok(rankingService.getRank(studentId));
  }

  @GetMapping("/students")
  public ResponseEntity<List<Rank>> getRankFromRange(@RequestParam("from") int from, @RequestParam("to") int to) {
    LOGGER.info("Received request to get the students from rank <{}> to <{}>", from, to);
    return ResponseEntity.ok(rankingService.getRanks(from, to));
  }
}