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
package com.sms.studentmanager.controller;

import com.sms.studentmanager.model.Rank;
import com.sms.studentmanager.service.RankingService;
import java.util.List;
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

  private final RankingService rankingService;

  public RankController(final RankingService rankingService) {
    this.rankingService = rankingService;
  }

  @PostMapping("/students")
  public ResponseEntity calculateRank() {
    rankingService.calculateRank();
    return ResponseEntity.ok().build();
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Rank> getRank(@PathVariable("id") int studentId) {
    return ResponseEntity.ok(rankingService.getRank(studentId));
  }

  @GetMapping("/students")
  public ResponseEntity<List<Rank>> getRankFromRange(@RequestParam("from") int from, @RequestParam("to") int to) {
    return ResponseEntity.ok(rankingService.getRanks(from, to));
  }
}