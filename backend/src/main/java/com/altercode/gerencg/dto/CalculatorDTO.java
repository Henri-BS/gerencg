package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Calculator;

public class CalculatorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long firstNumber;
	private Long secondNumber;
	
	public CalculatorDTO() {
		
	}
	
	public CalculatorDTO(Calculator entity) {		
		firstNumber = entity.getFirstProduct().getId();
		secondNumber = entity.getSecondProduct().getId();
	}
	
	public Long getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(Long firstNumber) {
		this.firstNumber = firstNumber;
	}

	public Long getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(Long secondNumber) {
		this.secondNumber = secondNumber;
	}	
}
