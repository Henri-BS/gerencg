package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import com.altercode.gerencg.service.OrderStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order-stats")
public class OrderStatsController {

    @Autowired
    private OrderStatsService statsService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatsDTO> findOrderStatsById(@PathVariable String id) {
        OrderStatsDTO findStats = statsService.findOrderStatsById(id);
        return ResponseEntity.ok(findStats);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<OrderStatsDTO>> findAllStats(Pageable pageable) {
        Page<OrderStatsDTO> page = statsService.findAllStats(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderStatsDTO> saveOrderStats(@RequestBody OrderStatsDTO dto) {
        OrderStatsDTO add = statsService.saveOrderStats(dto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderStatsDTO> updateStatsValues(OrderStatsDTO dto, @PathVariable String id) {
        OrderStatsDTO edit = statsService.updateStatsValues(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @GetMapping("/total-value")
    public ResponseEntity<OrderStatsValuesDTO> getOrderStatsTotalValues() {
        OrderStatsValuesDTO getStats = statsService.getOrderStatsTotalValues();
        return ResponseEntity.ok(getStats);
    }

}
