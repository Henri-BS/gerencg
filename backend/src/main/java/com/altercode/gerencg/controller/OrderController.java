package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CommissionService commissionService;

    @GetMapping("/orders")
    public ResponseEntity<Page<CommissionDTO>> findAllOrders(Pageable pageable) {
        Page<CommissionDTO> page = commissionService.findAllOrders(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/order/{id}")
    public CommissionDTO findOrderById(@PathVariable Long id) {
        return commissionService.findOrderById(id);
    }

    @PostMapping("/order/add")
    public ResponseEntity<CommissionDTO> saveOrder(@RequestBody CommissionDTO order) {
        CommissionDTO add = commissionService.addOrder(order);
        return new ResponseEntity<CommissionDTO>(add, HttpStatus.CREATED);
    }

    @PutMapping("/order/update")
    public ResponseEntity<CommissionDTO> updateOrder(@RequestBody CommissionDTO order) {
        CommissionDTO edit = commissionService.updateOrder(order);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/order/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        this.commissionService.deleteOrder(id);
    }

    @GetMapping("/order-info")
    public ResponseEntity<List<CommissionResultsDTO>> orderResults() {
        List<CommissionResultsDTO> list = commissionService.orderResults();
        return ResponseEntity.ok(list);
    }
}
