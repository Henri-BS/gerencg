package com.altercod.gerencg.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altercod.gerencg.dto.CategoryValueDTO;
import com.altercod.gerencg.dto.DetailDTO;
import com.altercod.gerencg.service.DetailService;

@RestController
@RequestMapping(value = "/details")
public class DetailController {

	@Autowired
	private DetailService service;
	
	@GetMapping
	public ResponseEntity<Page<DetailDTO>> findAll(Pageable pageable){
		Page<DetailDTO> list = service.findAll(pageable);
	 	return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/values-by-categories")
	public ResponseEntity<List<CategoryValueDTO>> valueGroupedByCategory(){
		List<CategoryValueDTO> list = service.valueGroupedByCategory();
		return ResponseEntity.ok(list);
	}
}
