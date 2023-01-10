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
    public ResponseEntity<Page<OrderItemDTO>> findAllItems(Pageable pageable) {
        Page<OrderItemDTO> page = itemService.findAllItems(pageable);
        return ResponseEntity.ok(page);
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
    public ResponseEntity<OrderItemDTO> findOrderById(@PathVariable Long id) {
        OrderItemDTO findItem = itemService.findItemById(id);
        return ResponseEntity.ok(findItem);
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
    public ResponseEntity<ProductDTO> updateProductByItem(OrderItemDTO item, Long id, Product product) {
        ProductDTO update = itemService.updateProductByItem(item, product);
        return ResponseEntity.ok(update);
    }
}