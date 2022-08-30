package com.altercode.gerencg.controller;

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

import com.altercode.gerencg.dto.CategoryProfileDTO;
import com.altercode.gerencg.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<CategoryProfileDTO>> findAll(Pageable pageable) {
        Page<CategoryProfileDTO> list = categoryService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public CategoryProfileDTO findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }
    
    @PostMapping("/add")
    public ResponseEntity<CategoryProfileDTO> addCategory(@RequestBody CategoryProfileDTO category) {
    	CategoryProfileDTO newCategory = categoryService.addCategory(category);
    	return new ResponseEntity<CategoryProfileDTO>(newCategory , HttpStatus.CREATED);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<CategoryProfileDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryProfileDTO category) {
    	CategoryProfileDTO updateCategory = categoryService.updateCategory(category);
    	return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
    	this.categoryService.deleteCategory(id);
    	
    }
}
