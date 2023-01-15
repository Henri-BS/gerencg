package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryValueDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Double income;

	public CategoryValueDTO(Category category, Double income) {
		categoryName = category.getName();
		this.income = income;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

}
