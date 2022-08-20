package com.altercode.gerencg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CalculatorDTO;
import com.altercode.gerencg.entity.Calculator;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CalculatorRepository;
import com.altercode.gerencg.repository.ProductRepository;

@Service 
@Transactional
public class CalculatorService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CalculatorRepository calculatorRepository;
	
	public CalculatorDTO sumProducts(CalculatorDTO dto) {
		
		Product product1 = productRepository.findById(dto.getFirstProduct()).get();
		Product product2 = productRepository.findById(dto.getSecondProduct()).get();
		
		Calculator calculator = new Calculator();
		calculator.setFirstProduct(product1);
		calculator.setSecondProduct(product2);
		calculator.getResult();
		
		calculator =  calculatorRepository.saveAndFlush(calculator);
		
		double firstValue = product1.getPrice();
		double secondValue = product2.getPrice();
		double result = 0.0;
		
		result = firstValue + secondValue;
		
		calculator.setResut(result);
		calculator = calculatorRepository.save(calculator);
		
		
		return new CalculatorDTO(calculator);
	}
}
