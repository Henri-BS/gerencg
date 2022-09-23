package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryValueDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Double income;
	private Double expense;
	
	public CategoryValueDTO(){}

	public CategoryValueDTO(Category category, Double income, Double expense) {
		this.categoryName = category.getName();
		this.income = income;
		this.expense = expense;
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

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	
}
