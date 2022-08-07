package com.altercode.gerencg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.MeasureDTO;
import com.altercode.gerencg.service.MeasureService;

@RestController
@RequestMapping(value = "/measure")
public class MeasureController {
	
	@Autowired
	private MeasureService measureService;
	
	@GetMapping(value = "/list")
	public List<MeasureDTO> findAll(){
		return measureService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public MeasureDTO findById(@PathVariable Long id){
		return measureService.findById(id);
		
	}
	
	
}
