package com.altercode.gerencg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.service.HistoryService;


@RestController
@RequestMapping("/history")
public class ProductHistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	@PutMapping
	public ProductDTO updateProductHistory(@RequestBody ProductHistoryDTO dto) {
		ProductDTO productDTO = historyService.updateProduct(dto);
		return productDTO;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Page<ProductHistoryDTO>> findAll(Pageable pageable) {
		Page<ProductHistoryDTO> page = historyService.findAll(pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{product}")
	public ResponseEntity<List<ProductHistoryDTO>> findByProduct(@PathVariable Product product) {
		List<ProductHistoryDTO> list = historyService.findByProduct(product);
		return ResponseEntity.ok(list);
	}

}
