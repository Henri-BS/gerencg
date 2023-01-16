package com.altercode.gerencg.controller;

import java.util.List;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.CategoryValueDTO;
import com.altercode.gerencg.service.CategoryStatsService;

@RestController
@RequestMapping(value = "/category-stats")
public class CategoryStatsController {
	
	@Autowired
	private CategoryStatsService statsService;
	
	@GetMapping("/list")
	public ResponseEntity<Page<CategoryStatsDTO>> findAll(Pageable pageable){
		Page<CategoryStatsDTO> page = statsService.findAll(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/total-value")
	public ResponseEntity<CategoryStatsTotalValueDTO> getCategoryStatsTotalValue(){
		CategoryStatsTotalValueDTO getStats = statsService.getCategoryStatsTotalValue();
		return  ResponseEntity.ok(getStats);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoryStatsDTO> saveStats(@RequestBody CategoryStatsDTO categoryStats) {
		CategoryStatsDTO newStats = statsService.saveStats(categoryStats);
		return new ResponseEntity<CategoryStatsDTO>( newStats, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CategoryStatsDTO> updateStats(@PathVariable Long id, @RequestBody CategoryStatsDTO dto) {
		CategoryStatsDTO updateStats = statsService.updateStats(dto);
		return new ResponseEntity<>(updateStats, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStats(@PathVariable Long id) {
		this.statsService.deleteStats(id);
	}
	
	@GetMapping("/value-of-category")
	public ResponseEntity<List<CategoryValueDTO>> valueGroupedByCategory(){
		List<CategoryValueDTO> list = statsService.priceGroupByCategory();
		return ResponseEntity.ok(list);
	}
	
}
