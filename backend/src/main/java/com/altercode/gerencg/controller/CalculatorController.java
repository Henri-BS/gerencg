package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.CalculatorDTO;
import com.altercode.gerencg.dto.RegisterDTO;
import com.altercode.gerencg.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@PutMapping
	public ResponseEntity<RegisterDTO> updateMeasure( @RequestBody CalculatorDTO dto) {
		RegisterDTO sumProducts = calculatorService.sumProducts(dto);
		return new ResponseEntity<>(sumProducts, HttpStatus.OK);
	}
	
}
