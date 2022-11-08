package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
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

    @GetMapping("/commission-list")
    public Page<CommissionItemDTO> findAllCommissions(Pageable pageable) {
      return commissionItemService.findAllCommissions(pageable);
    }

    @GetMapping("/find-code")
    public ResponseEntity<List<CommissionItemDTO>> findAllCommissionsByCode(CommissionCode code) {
        List<CommissionItemDTO> list = commissionItemService.findAllCommissionsByCode(code);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/order/{id}")
    public CommissionItemDTO findOrderById(@PathVariable Long id) {
        return commissionItemService.findCommissionById(id);
    }

    @PutMapping("/commission/add")
    public ProductDTO saveOrder(@RequestBody CommissionItemDTO order) {
        return commissionItemService.saveCommission(order);
    }

    @PutMapping("/commission/update")
    public ResponseEntity<CommissionItemDTO> updateOrder(@RequestBody CommissionItemDTO order) {
        CommissionItemDTO edit = commissionItemService.updateCommission(order);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/commission/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        this.commissionItemService.deleteCommission(id);
    }

    @GetMapping("/commission-info")
    public ResponseEntity<List<CommissionResultsDTO>> orderResults() {
        List<CommissionResultsDTO> list = commissionItemService.commissionResults();
        return ResponseEntity.ok(list);
    }
}