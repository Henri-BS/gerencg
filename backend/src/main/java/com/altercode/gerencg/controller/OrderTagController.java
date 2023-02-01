package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.service.OrderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-tag")
public class OrderTagController {

    @Autowired
    private OrderTagService orderTagService;

    @GetMapping("/list")
    public ResponseEntity<List<OrderTagDTO>> findAllOrderTags() {
        List<OrderTagDTO> list = orderTagService.findAllOrderTags();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/orders-by-tag/{tag}")
    public ResponseEntity<List<OrderTagDTO>> findAllOrdersByTag(@PathVariable Tag tag) {
        List<OrderTagDTO> list = orderTagService.findAllOrdersByTag(tag);
        return ResponseEntity.ok(list);
    }
}
