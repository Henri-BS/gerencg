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

	@GetMapping("/list")
	public ResponseEntity<Page<ProductHistoryDTO>> findAll(Pageable pageable) {
		Page<ProductHistoryDTO> page = productHistoryService.findAll(pageable);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductHistoryDTO> findHistoryById(@PathVariable Long id) {
		ProductHistoryDTO findHistory = productHistoryService.findHistoryById(id);
		return ResponseEntity.ok(findHistory);
	}

	@GetMapping("/product/{product}")
	public ResponseEntity<Page<ProductHistoryDTO>> findByProduct(Pageable pageable, @PathVariable Product product) {
		Page<ProductHistoryDTO> page = productHistoryService.findByProduct(pageable, product);
		return ResponseEntity.ok(page);
	}

	@PostMapping("/save-product")
	public ProductHistoryDTO saveProductHistory(@RequestBody ProductHistoryDTO dto) {
		return productHistoryService.saveHistory(dto);
	}

	@PostMapping("/save-item/{id}")
	public ProductHistoryDTO saveItemHistory(@PathVariable Long id) {
		return productHistoryService.saveItemHistory(id);
	}

	@PutMapping("/update")
	public ResponseEntity<ProductHistoryDTO> updateHistory(@RequestBody ProductHistoryDTO dto) {
		ProductHistoryDTO update = productHistoryService.updateHistory(dto);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@PutMapping("/update-value/{id}")
	public ResponseEntity<ProductHistoryDTO> updateProductHistoryValue(ProductHistoryDTO dto, @PathVariable Long id) {
		ProductHistoryDTO update = productHistoryService.updateProductHistoryValue(dto);
		return new ResponseEntity<>(update, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProductHistory(@PathVariable Long id) {
		this.productHistoryService.deleteProductHistory(id);
	}
}