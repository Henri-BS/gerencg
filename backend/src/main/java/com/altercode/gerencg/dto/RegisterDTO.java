package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Register;

public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long firstProduct;
	private Long secondProduct;
	private Double result;
	
	public RegisterDTO() {
	
	}

	public RegisterDTO(Register entity) {
		firstProduct = entity.getFirstProduct().getId();
		secondProduct = entity.getSecondProduct().getId();
		result = entity.getValue();
	}

	public Long getFirstProduct() {
		return firstProduct;
	}

	public void setFirstProduct(Long firstProduct) {
		this.firstProduct = firstProduct;
	}

	public Long getSecondProduct() {
		return secondProduct;
	}

	public void setSecondProduct(Long secondProduct) {
		this.secondProduct = secondProduct;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

}
