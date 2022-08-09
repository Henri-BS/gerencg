package com.altercode.gerencg.dto;

import java.time.LocalDate;

import com.altercode.gerencg.entity.CategoryStats;

public class CategoryStatsDTO {
	private Long id;
	private Integer addedProducts;
	private Integer removedProducts;
	private Double income;
	private Double expense;
	private LocalDate registrationDate;
	
	private CategoryDTO category;
	
	public CategoryStatsDTO() {}

	public CategoryStatsDTO(Long id, Integer addedProducts, Integer removedProducts, Double income, Double expense, LocalDate registrationDate,
			CategoryDTO category) {
		this.id = id;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
		this.income = income;
		this.expense = expense;
		this.registrationDate = registrationDate;
		this.category = category;
	}
	
	public CategoryStatsDTO(CategoryStats entity) {
		id = entity.getId();
		addedProducts = entity.getAddedProducts();
		removedProducts = entity.getRemovedProducts();
		income = entity.getIncome();
		expense = entity.getExpense();
		registrationDate = entity.getRegistrationDate();
		category = new CategoryDTO(entity.getCategory());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAddedProducts() {
		return addedProducts;
	}

	public void setAddedProducts(Integer addedProducts) {
		this.addedProducts = addedProducts;
	}

	public Integer getRemovedProducts() {
		return removedProducts;
	}

	public void setRemovedProducts(Integer removedProducts) {
		this.removedProducts = removedProducts;
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
}
