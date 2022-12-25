package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.service.ProductService;
import com.altercode.gerencg.service.SmsService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private SmsService smsService;
	
	@GetMapping("/product-search")
	public ResponseEntity<Page<ProductDTO>> findByDescription(Pageable pageable, String description) {
		Page<ProductDTO> page = service.findAll(pageable, description);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/product-validate")
	public ResponseEntity<Page<ProductDTO>> findAllByValidate(
			@RequestParam(value = "minValidate", defaultValue = "") String minValidate, 
			@RequestParam(value = "maxValidate", defaultValue = "") String maxValidate, 
			Pageable pageable) {
		
		Page<ProductDTO> list = service.findAllByValidate(minValidate, maxValidate, pageable);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/find-products-by-category/{category}")
	public ResponseEntity<Page<ProductDTO>> findByCategory(Pageable pageable, Category category) {
		Page<ProductDTO> list = service.findByCategory(pageable, category);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/find-products-by-measure/{measure}")
	public ResponseEntity<Page<ProductDTO>> findByMeasure(Pageable pageable, Measure measure) {
		Page<ProductDTO> list = service.findByMeasure(pageable, measure);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/product/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/product-description/{description}")
	public ProductDTO findByDescription(@PathVariable String description) {
	return service.findByDescription(description);
	}

		@PostMapping("/product-add")
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product) {
		ProductDTO newProduct = service.saveProduct(product);
		return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.CREATED);
	}

	@DeleteMapping("/product-delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		this.service.deleteProduct(id);
	}


	@GetMapping("/product/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
