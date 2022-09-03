package com.altercode.gerencg.controller;

import java.util.List;

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

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/list")
	public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
		Page<ProductDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable Long id){
		return service.findById(id);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
		ProductDTO newProduct = service.addProduct(product);
		return new ResponseEntity<ProductDTO>(newProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO porduct) {
		ProductDTO editProduct = service.updateProduct(porduct);
		return new ResponseEntity<>(editProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		this.service.deleteProduct(id);
	}
	
	@GetMapping("/find-all-by-id")
	public List<ProductDTO> findAllProductsById(@RequestBody List<Long> ids) {
		return service.findAllProductsById(ids);
	}
	
	@GetMapping("/find-by-category/{category}")
	public ResponseEntity<List<ProductDTO>> findByCategory(Category category){
		List<ProductDTO> list = service.findByCategory(category);
		return ResponseEntity.ok(list);
	}
}
