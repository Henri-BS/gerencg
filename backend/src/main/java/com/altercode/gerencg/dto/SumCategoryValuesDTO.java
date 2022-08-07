package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Category;

public class SumCategoryValuesDTO {
	
	private String name;
private Double expense;
private Double income;

public SumCategoryValuesDTO() {

}


public SumCategoryValuesDTO(Category category, Double expense, Double income) {
	this.name = category.getName();
	this.expense = expense;
	this.income = income;
}




public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public Double getExpense() {
	return expense;
}

public void setExpense(Double expense) {
	this.expense = expense;
}

public Double getIncome() {
	return income;
}

public void setIncome(Double income) {
	this.income = income;
}



}
