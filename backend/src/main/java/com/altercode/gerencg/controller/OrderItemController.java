package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService itemService;

    @GetMapping("/items-list")
    public Page<OrderItemDTO> findAllItems(Pageable pageable) {
      return itemService.findAllItems(pageable);
    }

    @GetMapping("/find-code")
    public ResponseEntity<List<OrderItemDTO>> findItemsByCode(OrderCode code) {
        List<OrderItemDTO> list = itemService.findItemsByCode(code);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find-item-by-product/{product}")
    public ResponseEntity<List<OrderItemDTO>> findItemByProduct(Product product) {
        List<OrderItemDTO> list = itemService.findItemByProduct(product);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/item/{id}")
    public OrderItemDTO findOrderById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @PostMapping("/save-item")
    public ResponseEntity<OrderItemDTO> saveItem(@RequestBody OrderItemDTO item) {
        OrderItemDTO newItem = itemService.saveItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update-item")
    public ResponseEntity<OrderItemDTO> updateItem(@RequestBody OrderItemDTO item) {
        OrderItemDTO edit = itemService.updateItem(item);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        this.itemService.deleteItem(id);
    }

    @PutMapping("/update-product-by-item")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProductByItem(OrderItemDTO item, Long id, Product product) {
        return itemService.updateProductByItem(item);
    }

    }