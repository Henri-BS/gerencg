package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.altercode.gerencg.entity.CategoryStats;

public class CategoryStatsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate registrationDate;
	private Integer addedProducts;
	private Integer removedProducts;
	private Double income;
	private Double expense;
	
	private String category;
	
	public CategoryStatsDTO() {}

	public CategoryStatsDTO(Long id, LocalDate registrationDate, Integer addedProducts, Integer removedProducts,
			Double income, Double expense, String category) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
		this.income = income;
		this.expense = expense;
		this.category = category;
	}

	public CategoryStatsDTO(CategoryStats entity) {
		id = entity.getId();		
		registrationDate = entity.getRegistrationDate();
		addedProducts = entity.getAddedProducts();
		removedProducts = entity.getRemovedProducts();
		income = entity.getIncome();
		expense = entity.getExpense();
		category = entity.getCategory().getName();
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
