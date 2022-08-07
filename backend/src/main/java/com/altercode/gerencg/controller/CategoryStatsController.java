package com.altercode.gerencg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.CategoryFlowDTO;
import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.SumCategoryValuesDTO;
import com.altercode.gerencg.service.CategoryStatsService;

@RestController
@RequestMapping(value = "/details")
public class CategoryStatsController {
	
	@Autowired
	private CategoryStatsService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoryStatsDTO>> findAll(Pageable pageable){
		Page<CategoryStatsDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/value-of-category")
	public ResponseEntity<List<SumCategoryValuesDTO>> valueGroupedByCategory(){
		List<SumCategoryValuesDTO> list = service.valueGroupedByCategory();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/flow-of-category")
	public ResponseEntity<List<CategoryFlowDTO>> flowGroupedByCategory(){
		List<CategoryFlowDTO> list = service.flowGroupedByCategory();
		return ResponseEntity.ok(list);
	}
	
}
