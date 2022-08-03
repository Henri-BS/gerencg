package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryValueDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Double sum;
	
	public CategoryValueDTO(){}

	public CategoryValueDTO(Category category, Double sum) {
		this.categoryName = category.getName();
		this.sum = sum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
		
}
