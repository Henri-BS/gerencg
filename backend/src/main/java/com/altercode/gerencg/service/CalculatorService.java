package com.altercode.gerencg.service;

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
		
		Product product = productRepository.findById(dto.getProductId()).get();

		Calculator calculator = new Calculator();
		calculator.setFirstProduct(product);
		calculator.setSecondProduct(product);
		calculator.setResult(dto.getResult());
		
		calculator =  calculatorRepository.save(calculator);
		
		double price = product.getPrice();
		for(Calculator c : product.getCalculators()) {
			price = price + c.getResult();
		}
		
		
		return new CalculatorDTO();
	}
}
