package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Calculator;

public class CalculatorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long firstProduct;
	private Long secondProduct;
	private Double result;
	
	public CalculatorDTO() {
		
	}
	
	public CalculatorDTO(Calculator entity) {		
		firstProduct = entity.getFirstProduct().getId();
		secondProduct = entity.getSecondProduct().getId();
		result = entity.getResult();
	}
	
	public Long getFirstProduct() {
		return firstProduct;
	}

	public void setFirstProduct(Long firstNumber) {
		this.firstProduct = firstNumber;
	}

	public Long getSecondProduct() {
		return secondProduct;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}	
	
	
}
