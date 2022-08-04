package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Register;

public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long categoryId;
	private Long productId;
	private Integer value;
	
	public RegisterDTO() {
	
	}

	public RegisterDTO(Register entity) {
		categoryId = entity.getCategory().getId();
		productId = entity.getProduct().getId();
		value = entity.getValue();
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
