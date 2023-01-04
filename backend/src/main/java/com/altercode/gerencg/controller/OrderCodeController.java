package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.OrderCodeDTO;
import com.altercode.gerencg.dto.SumOrderQuantityCategoryDTO;
import com.altercode.gerencg.dto.SumOrderValueCategoryDTO;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.service.OrderCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderCodeController {

    @Autowired
    private OrderCodeService codeService;

    @GetMapping("/list")
    public ResponseEntity<Page<OrderCodeDTO>> findItemsByCode(Pageable pageable, String code) {
        Page<OrderCodeDTO> page = codeService.findItemsByCode(pageable, code);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public OrderCodeDTO findCodeById(@PathVariable String id) {
        return codeService.findCodeById(id);
    }

    @GetMapping("/find-by-stats/{stats}")
    public ResponseEntity<Page<OrderCodeDTO>> findOrderByStats(Pageable pageable, @PathVariable OrderStats stats) {
        Page<OrderCodeDTO> list = codeService.findOrdersByStats(pageable, stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sum-value-by-category")
    public ResponseEntity<List<SumOrderValueCategoryDTO>> getOrderValueGroupByCategory() {
        List<SumOrderValueCategoryDTO> getOrders = codeService.getOrderValueGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @GetMapping("/sum-quantity-by-category")
    public ResponseEntity<List<SumOrderQuantityCategoryDTO>> getOrderQuantityGroupByCategory() {
        List<SumOrderQuantityCategoryDTO> getOrders = codeService.getOrderQuantityGroupByCategory();
        return ResponseEntity.ok(getOrders);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderCodeDTO> saveOrderCode(@RequestBody OrderCodeDTO dto) {
        OrderCodeDTO addCode = codeService.saveOrder(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderCodeDTO> updateOrder(@RequestBody OrderCodeDTO dto) {
        OrderCodeDTO editCode = codeService.updateOrder(dto);
        return new ResponseEntity<>(editCode, HttpStatus.OK);
    }

    @PutMapping("/sum-item-values/{code}")
    public ResponseEntity<OrderCodeDTO> orderTotalValues(OrderCodeDTO dto, @PathVariable String code) {
        OrderCodeDTO update = codeService.orderTotalValues(dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String id){
        this.codeService.deleteOrder(id);
    }
}
