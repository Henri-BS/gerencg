package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionStatsValuesDTO;
import com.altercode.gerencg.entity.CommissionStats;
import com.altercode.gerencg.service.CommissionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find-commissions-by-stats/{stats}")
    public ResponseEntity<List<CommissionCodeDTO>> findCommissionsByStats(@PathVariable CommissionStats stats) {
        List<CommissionCodeDTO> list = codeService.findCommissionsByStats(stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/update-period-stats/{stats}")
    public ResponseEntity<List<CommissionCodeDTO>> findCommissionsByPeriod(@PathVariable CommissionStats stats){
        List<CommissionCodeDTO> list = codeService.findCommissionsByPeriod(stats);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/commission-stats-values")
    public List<CommissionStatsValuesDTO> statsValues(){
        return codeService.statsValues();
    }

    @PostMapping("/save-commission")
    public ResponseEntity<CommissionCodeDTO> saveCommissionCode(@RequestBody CommissionCodeDTO dto) {
        CommissionCodeDTO addCode = codeService.saveCommission(dto);
        return new ResponseEntity<>(addCode, HttpStatus.CREATED);
    }

    @PutMapping("/update-commission")
    public ResponseEntity<CommissionCodeDTO> updateCommission(@RequestBody CommissionCodeDTO dto) {
        CommissionCodeDTO editCode = codeService.updateCommission(dto);
        return new ResponseEntity<>(editCode, HttpStatus.OK);
    }

    @PutMapping("/sum-item-values/{code}")
    public CommissionCodeDTO commissionTotalValues(CommissionCodeDTO dto, @PathVariable String code) {
        return codeService.commissionTotalValues(dto);
    }

    @DeleteMapping("/delete-commission/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommission(@PathVariable String id){
        this.codeService.deleteCommission(id);
    }
}
