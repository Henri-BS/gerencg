package com.altercode.gerencg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CalculatorDTO;
import com.altercode.gerencg.dto.RegisterDTO;
import com.altercode.gerencg.entity.Calculator;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.Register;
import com.altercode.gerencg.repository.CalculatorRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.repository.RegisterRepository;

@Service 
@Transactional
public class CalculatorService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CalculatorRepository calculatorRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public RegisterDTO sumProducts(CalculatorDTO dto) {
		
		Product product1 = productRepository.findById(dto.getFirstNumber()).get();
		Product product2 = productRepository.findById(dto.getSecondNumber()).get();
		Register register =  registerRepository.findById(dto.getFirstNumber()).get();

		Calculator calculator = new Calculator();
		calculator.setFirstProduct(product1);
		calculator.setSecondProduct(product2);
		
		calculator =  calculatorRepository.saveAndFlush(calculator);
		
		double sum = calculator.getFirstProduct().getPrice();
		for(Calculator c : product1.getCalculators()) {
			sum = sum + c.getSecondProduct().getPrice();
		}
		
		register.setValue(sum);
		register = registerRepository.save(register);
		
		
		return new RegisterDTO(register);
	}
}
