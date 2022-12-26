package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.service.OrderStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order-stats")
public class OrderStatsController {

    @Autowired
    private OrderStatsService statsService;

    @GetMapping("/page")
    public Page<OrderStatsDTO> findAllStats( Pageable pageable){
        return statsService.findAllStats(pageable);
    }

    @PostMapping("/save")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Order stats was created")
    public OrderStatsDTO saveOrderStats(@RequestBody OrderStatsDTO dto) {
        return statsService.saveOrderStats(dto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(value = HttpStatus.OK, reason = "Total order quantity has been updated")
    public OrderStatsDTO updateStatsValues(OrderStatsDTO dto, @PathVariable String id){
        return statsService.updateStatsValues(dto);
    }

}
