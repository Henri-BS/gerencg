package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

     @GetMapping("/orders")
     public ResponseEntity<Page<OrderDTO>> findAllOrders(Pageable pageable) {
         Page<OrderDTO> page = orderService.findAllOrders(pageable);
         return ResponseEntity.ok(page);
     }

     @GetMapping("/order/{id}")
     public OrderDTO findOrderById(@PathVariable String id) {
         return orderService.findOrderById(id);
     }

     @PostMapping("/order/add")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO order) {
         OrderDTO add = orderService.addOrder(order);
         return new ResponseEntity<OrderDTO>(add, HttpStatus.CREATED);
     }

     @PutMapping("/order/update")
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO order) {
         OrderDTO edit = orderService.updateOrder(order);
         return new ResponseEntity<>(edit, HttpStatus.OK);
     }

     @DeleteMapping("/order/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String id) {
         this.orderService.deleteOrder(id);
     }
}
