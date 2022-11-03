package com.altercode.gerencg.controller;

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
import com.altercode.gerencg.service.ProductHistoryService;


@RestController
@RequestMapping("/history")
public class ProductHistoryController {

	@Autowired
	private ProductHistoryService productHistoryService;

	@PutMapping
	public ProductDTO updateProductHistory(@RequestBody ProductHistoryDTO dto) {
		return productHistoryService.updateProduct(dto);
	}

	@GetMapping("/list")
	public ResponseEntity<Page<ProductHistoryDTO>> findAll(Pageable pageable) {
		Page<ProductHistoryDTO> page = productHistoryService.findAll(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{product}")
	public ResponseEntity<Page<ProductHistoryDTO>> findByProduct(Pageable pageable, @PathVariable Product product) {
		Page<ProductHistoryDTO> page = productHistoryService.findByProduct(pageable, product);
		return ResponseEntity.ok(page);
	}
}