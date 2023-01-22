package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.service.ProductHistoryService;


@RestController
@RequestMapping("/history")
public class ProductHistoryController {

	@Autowired
	private ProductHistoryService productHistoryService;

	@PostMapping
	public ProductHistoryDTO saveProductInHistory(@RequestBody ProductHistoryDTO dto) {
		return productHistoryService.saveHistory(dto);
	}

	@PostMapping("/save-item/{id}")
	public ProductHistoryDTO saveItemInHistory(@PathVariable Long id) {
		return productHistoryService.saveItemInHistory(id);
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

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductHistory(@PathVariable Long id) {
		this.productHistoryService.deleteProductHistory(id);
	}
}