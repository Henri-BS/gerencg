package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderCodeDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.service.OrderCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderCodeController {

    @Autowired
    private OrderCodeService codeService;

    @GetMapping("/commission-list")
    public ResponseEntity<Page<OrderCodeDTO>> findItemsByCode(Pageable pageable, String code) {
        Page<OrderCodeDTO> page = codeService.findItemsByCode(pageable, code);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/commission/{id}")
    public OrderCodeDTO findCodeById(@PathVariable String id) {
        return codeService.findCodeById(id);
    }

    @GetMapping("/find-commissions-by-stats/{stats}")
    public ResponseEntity<List<OrderCodeDTO>> findCommissionsByStats(@PathVariable OrderStats stats) {
        List<OrderCodeDTO> list = codeService.findOrdersByStats(stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/commission-stats-values")
    public List<OrderStatsValuesDTO> statsValues(){
        return codeService.statsValues();
    }

    @PostMapping("/save-commission")
    public ResponseEntity<OrderCodeDTO> saveCommissionCode(@RequestBody OrderCodeDTO dto) {
        OrderCodeDTO addCode = codeService.saveOrder(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }

    @PutMapping("/update-commission")
    public ResponseEntity<OrderCodeDTO> updateCommission(@RequestBody OrderCodeDTO dto) {
        OrderCodeDTO editCode = codeService.updateOrder(dto);
        return new ResponseEntity<>(editCode, HttpStatus.OK);
    }

    @PutMapping("/sum-item-values/{code}")
    public OrderCodeDTO commissionTotalValues(OrderCodeDTO dto, @PathVariable String code) {
        return codeService.orderTotalValues(dto);
    }

    @DeleteMapping("/delete-commission/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommission(@PathVariable String id){
        this.codeService.deleteOrder(id);
    }
}
