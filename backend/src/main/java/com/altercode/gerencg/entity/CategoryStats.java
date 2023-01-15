package com.altercode.gerencg.entity;

import java.time.LocalDate;

import javax.persistence.*;


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

	private Double income = 0.0;

	@Column(name = "max_income")
	private Double maxIncome = 0.0;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public CategoryStats(){}
	
	public CategoryStats(Long id, Integer addedProducts,
			LocalDate registrationDate, Double income, Double maxIncome,  Category category) {
		this.id = id;
		this.registrationDate = registrationDate;
		this.addedProducts = addedProducts;
		this.income = income;
		this.maxIncome = maxIncome;
		this.category = category;
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

	public Double getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(Double maxIncome) {
		this.maxIncome = maxIncome;
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
