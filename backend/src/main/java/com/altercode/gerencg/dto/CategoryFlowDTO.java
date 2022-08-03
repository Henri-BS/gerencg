package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryFlowDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Long prod_adc;
	private Long prod_remov;
	
	
	public CategoryFlowDTO(){}

	public CategoryFlowDTO(Category category, Long prod_adc, Long prod_remov) {
		categoryName = category.getName();
		this.prod_adc = prod_adc;
		this.prod_remov = prod_remov;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getProd_adc() {
		return prod_adc;
	}

	public void setProd_adc(Long prod_adc) {
		this.prod_adc = prod_adc;
	}

	public Long getProd_remov() {
		return prod_remov;
	}

	public void setProd_remov(Long prod_remov) {
		this.prod_remov = prod_remov;
	}



	
		
}
