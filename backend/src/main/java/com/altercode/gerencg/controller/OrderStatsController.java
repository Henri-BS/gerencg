package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.service.OrderStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderStatsController {

    @Autowired
    private OrderStatsService statsService;

    @GetMapping("/commission-stats-list")
    public ResponseEntity<List<OrderStatsDTO>> findAllStats(String id){
        List<OrderStatsDTO> list = statsService.findAllStats(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/commission-stats-save")
    public ResponseEntity<OrderStatsDTO> saveCommissionStats(@RequestBody OrderStatsDTO dto) {
        OrderStatsDTO addStats = statsService.saveCommissionStats(dto);
        return new ResponseEntity<>(addStats, HttpStatus.CREATED);
    }

    @PutMapping("/commission-stats-update/{id}")
    public OrderStatsDTO updateCommissionStats(OrderStatsDTO dto, @PathVariable String id){
        return statsService.updateStatsValues(dto);
    }

}
