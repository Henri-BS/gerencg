package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.service.interf.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class OrderItemController {

    @Autowired
    private OrderItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<Page<OrderItemDTO>> findAllItems(Pageable pageable) {
        Page<OrderItemDTO> page = itemService.findItems(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/order/{order}")
    public ResponseEntity<List<OrderItemDTO>> findItemsByOrder(@PathVariable Order order) {
        List<OrderItemDTO> list = itemService.findItemsByOrder(order);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find-by-product/{product}")
    public ResponseEntity<List<OrderItemDTO>> findItemByProduct(@PathVariable Product product) {
        List<OrderItemDTO> list = itemService.findItemByProduct(product);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> findOrderById(@PathVariable Long id) {
        OrderItemDTO findItem = itemService.findItemById(id);
        return ResponseEntity.ok(findItem);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderItemDTO> saveItem(@RequestBody OrderItemDTO item) {
        OrderItemDTO newItem = itemService.saveItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<OrderItemDTO> updateItem(@RequestBody OrderItemDTO item) {
        OrderItemDTO edit = itemService.updateItem(item);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PutMapping("/update-product")
    public ResponseEntity<ProductDTO> updateProductByItem(OrderItemDTO item, Long id) {
        ProductDTO update = itemService.updateProductByItem(item);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        this.itemService.deleteItem(id);
    }


}