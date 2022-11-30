package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.service.CommissionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommissionItemController {

    @Autowired
    private CommissionItemService commissionItemService;

    @GetMapping("/items-list")
    public Page<CommissionItemDTO> findAllItems(Pageable pageable) {
      return commissionItemService.findAllItems(pageable);
    }

    @GetMapping("/find-code")
    public ResponseEntity<List<CommissionItemDTO>> findItemsByCode(CommissionCode code) {
        List<CommissionItemDTO> list = commissionItemService.findItemsByCode(code);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/find-item-by-product/{product}")
    public ResponseEntity<List<CommissionItemDTO>> findItemByProduct(Product product) {
        List<CommissionItemDTO> list = commissionItemService.findItemByProduct(product);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/item/{id}")
    public CommissionItemDTO findOrderById(@PathVariable Long id) {
        return commissionItemService.findItemById(id);
    }

    @PostMapping("/save-item")
    public ResponseEntity<CommissionItemDTO> saveItem(@RequestBody CommissionItemDTO item) {
        CommissionItemDTO newItem = commissionItemService.saveItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update-item")
    public ResponseEntity<CommissionItemDTO> updateItem(@RequestBody CommissionItemDTO item) {
        CommissionItemDTO edit = commissionItemService.updateItem(item);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete-item/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        this.commissionItemService.deleteItem(id);
    }

    @GetMapping("/item-info")
    public ResponseEntity<List<CommissionResultsDTO>> orderResults() {
        List<CommissionResultsDTO> list = commissionItemService.commissionResults();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update-product-by-item")
    public ProductDTO updateProductByItem(CommissionItemDTO item, Long id, Product product) {
        return commissionItemService.updateProductByItem(item);
    }

    }