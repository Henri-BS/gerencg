package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.service.interf.OrderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-tag")
public class OrderTagController {

    @Autowired
    private OrderTagService orderTagService;

    @GetMapping("/list")
    public ResponseEntity<Page<OrderTagDTO>> findAll(Pageable pageable) {
        Page<OrderTagDTO> list = orderTagService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find-by-tag/{tag}")
    public ResponseEntity<List<OrderTagDTO>> findByTag(@PathVariable Tag tag) {
        List<OrderTagDTO> list = orderTagService.findByTag(tag);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find-by-order/{order}")
    public ResponseEntity<List<OrderTagDTO>> findByOrder(@PathVariable Order order) {
        List<OrderTagDTO> list = orderTagService.findByOrder(order);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderTagDTO> findOrderTagById(@PathVariable Long id) {
        OrderTagDTO find = orderTagService.findOrderTagById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderTagDTO> saveOrderTag(@RequestBody OrderTagDTO dto) {
        OrderTagDTO add = orderTagService.saveOrderTag(dto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderTag(@PathVariable Long id) {
        this.orderTagService.deleteOrderTag(id);
    }
}
