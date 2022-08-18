package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Calculator;
import com.altercode.gerencg.entity.Register;

public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long firstProduct;
	private Long secondProduct;
	private Double result;
	
	public RegisterDTO() {
	
	}

	public RegisterDTO(Register entity) {
		
	}

	public Long getCategoryId() {
		return firstProduct;
	}

	public void setCategoryId(Long categoryId) {
		this.firstProduct = categoryId;
	}

	public Long getProductId() {
		return secondProduct;
	}

	public void setProductId(Long productId) {
		this.secondProduct = productId;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

}
