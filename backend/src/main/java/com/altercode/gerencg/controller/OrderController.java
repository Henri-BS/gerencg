package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService codeService;

    @GetMapping("/list")
    public ResponseEntity<Page<OrderDTO>> findOrders(Pageable pageable, @RequestParam(defaultValue = "") String code) {
        Page<OrderDTO> page = codeService.findOrders(pageable, code);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public OrderDTO findCodeById(@PathVariable String id) {
        return codeService.findCodeById(id);
    }

    @GetMapping("/find-by-stats/{stats}")
    public ResponseEntity<Page<OrderDTO>> findOrderByStats(Pageable pageable, @PathVariable OrderStats stats) {
        Page<OrderDTO> list = codeService.findOrdersByStats(pageable, stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sum-value-by-category")
    public ResponseEntity<List<CategoryStatsTotalValueDTO>> getOrderValueGroupByCategory() {
        List<CategoryStatsTotalValueDTO> getOrders = codeService.getOrderValueGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @GetMapping("/sum-quantity-by-category")
    public ResponseEntity<List<CategoryStatsTotalValueDTO>> getOrderQuantityGroupByCategory() {
        List<CategoryStatsTotalValueDTO> getOrders = codeService.getOrderQuantityGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrderCode(@RequestBody OrderDTO dto) {
        OrderDTO addCode = codeService.saveOrder(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO dto) {
        OrderDTO editCode = codeService.updateOrder(dto);
        return new ResponseEntity<>(editCode, HttpStatus.OK);
    }

    @PutMapping("/sum-item-values/{code}")
    public ResponseEntity<OrderDTO> orderTotalValues(OrderDTO dto, @PathVariable String code) {
        OrderDTO update = codeService.orderTotalValues(dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String id){
        this.codeService.deleteOrder(id);
    }
}
