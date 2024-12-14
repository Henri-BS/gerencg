package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.service.interf.OrderService;
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
    private OrderService orderService;

    @GetMapping("/list")
    public ResponseEntity<Page<OrderDTO>> findOrders(Pageable pageable, @RequestParam(defaultValue = "") String order) {
        Page<OrderDTO> page = orderService.findOrders(pageable, order);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public OrderDTO findOrderById(@PathVariable String id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("/find-by-stats/{stats}")
    public ResponseEntity<Page<OrderDTO>> findOrderByStats(Pageable pageable, @PathVariable OrderStats stats) {
        Page<OrderDTO> list = orderService.findOrdersByStats(pageable, stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sum-value-by-category")
    public ResponseEntity<List<CategoryStatsTotalValueDTO>> getOrderValueGroupByCategory() {
        List<CategoryStatsTotalValueDTO> getOrders = orderService.getOrderValueGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @GetMapping("/sum-quantity-by-category")
    public ResponseEntity<List<CategoryStatsTotalValueDTO>> getOrderQuantityGroupByCategory() {
        List<CategoryStatsTotalValueDTO> getOrders = orderService.getOrderQuantityGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO dto) {
        OrderDTO addCode = orderService.saveOrder(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO dto) {
        OrderDTO editCode = orderService.updateOrder(dto);
        return new ResponseEntity<>(editCode, HttpStatus.OK);
    }

    @PutMapping("/sum-item-values/{id}")
    public ResponseEntity<OrderDTO> orderTotalValues(OrderDTO dto, @PathVariable String id) {
        OrderDTO update = orderService.orderTotalValues(dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String id){
        this.orderService.deleteOrder(id);
    }
}
