package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.service.CommissionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommissionCodeController {

    @Autowired
    private CommissionCodeService codeService;

    @GetMapping("/commission-list")
    public ResponseEntity<Page<CommissionCodeDTO>> findItemsByCode(Pageable pageable, String code) {
        Page<CommissionCodeDTO> page = codeService.findItemsByCode(pageable, code);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/commission/{id}")
    public CommissionCodeDTO findCodeById(@PathVariable String id) {
        return codeService.findCodeById(id);
    }

    @PutMapping("/sum-item-values/{code}")
    public CommissionCodeDTO commissionTotalValues(CommissionCodeDTO dto, @PathVariable String code) {
        return codeService.commissionTotalValues(dto);
    }

    @PostMapping("/save-commission")
    public ResponseEntity<CommissionCodeDTO> saveCommissionCode(@RequestBody CommissionCodeDTO dto) {
        CommissionCodeDTO addCode = codeService.saveCommissionCode(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }
}
