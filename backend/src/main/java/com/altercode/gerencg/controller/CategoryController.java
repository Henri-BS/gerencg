package com.altercode.gerencg.controller;

import com.altercode.gerencg.entity.Category;
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

import com.altercode.gerencg.dto.CategoryDTO;
import com.altercode.gerencg.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<CategoryDTO>> findAll(Pageable pageable) {
        Page<CategoryDTO> list = categoryService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable String id) {
        CategoryDTO find = categoryService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
    	CategoryDTO newCategory = categoryService.addCategory(category);
    	return new ResponseEntity<>(newCategory , HttpStatus.CREATED);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO category) {
    	CategoryDTO edit = categoryService.updateCategory(category);
    	return new ResponseEntity<>(edit, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable String id) {
    	this.categoryService.deleteCategory(id);
    }
}
