package com.altercode.gerencg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_category_stats")
public class CategoryStats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "added_products")
	private Integer addedProducts;
	
	@Column(name = "removed_products")
	private Integer removedProducts;
	
	private Double expense;

	private Double income;

	@Column(name = "registration_date")
	private LocalDate registrationDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public CategoryStats(){}
	
	public CategoryStats(Long id, Integer addedProducts, Integer removedProducts, 
			Double categoryValue, LocalDate registrationDate, 
			Double expense, Double income,  Category category) {
		this.id = id;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
		this.expense = expense;
		this.income = income;
		this.registrationDate = registrationDate;
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
