package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionStatsDTO;
import com.altercode.gerencg.service.CommissionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommissionStatsController {

    @Autowired
    private CommissionStatsService statsService;

    @PostMapping("/commission-stats-save")
    public ResponseEntity<CommissionStatsDTO> saveCommissionStats(@RequestBody CommissionStatsDTO dto) {
        CommissionStatsDTO addStats = statsService.saveCommissionStats(dto);
        return new ResponseEntity<>(addStats, HttpStatus.CREATED);
    }
}
