package com.altercode.gerencg.dto;

import java.io.Serializable;

public class CalculatorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long productId;
	private Double firstNumber;
	private Double secondNumber;
	private Double result; 
	
	public CalculatorDTO() {
		
	}
	
	public CalculatorDTO(Double firstNumber, Double secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	
	
	
}
