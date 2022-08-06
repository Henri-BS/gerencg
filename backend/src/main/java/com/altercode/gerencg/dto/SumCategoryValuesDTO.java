package com.altercode.gerencg.dto;

public class SumCategoryValuesDTO {
	
	private String name;
private Double expense;
private Double income;

public SumCategoryValuesDTO() {

}


public SumCategoryValuesDTO(String name, Double expense, Double income) {
	this.name = name;
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
