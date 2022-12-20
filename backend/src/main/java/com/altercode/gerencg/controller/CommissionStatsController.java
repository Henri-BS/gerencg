package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionStatsDTO;
import com.altercode.gerencg.service.CommissionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommissionStatsController {

    @Autowired
    private CommissionStatsService statsService;

    @GetMapping("/commission-stats-list")
    public ResponseEntity<List<CommissionStatsDTO>> findAllStats(String id){
        List<CommissionStatsDTO> list = statsService.findAllStats(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/commission-stats-save")
    public ResponseEntity<CommissionStatsDTO> saveCommissionStats(@RequestBody CommissionStatsDTO dto) {
        CommissionStatsDTO addStats = statsService.saveCommissionStats(dto);
        return new ResponseEntity<>(addStats, HttpStatus.CREATED);
    }
}
