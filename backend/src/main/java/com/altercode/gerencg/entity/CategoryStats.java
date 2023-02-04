package com.altercode.gerencg.entity;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "tb_category_stats")
public class CategoryStats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "added_products")
	private Integer addedProducts;

	private Double income = 0.0;

	@Column(name = "max_income")
	private Double maxIncome = 0.0;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public CategoryStats(){}
	
	public CategoryStats(Long id, Integer addedProducts, LocalDateTime lastModifiedDate,
						 Double income, Double maxIncome, Category category) {
		this.id = id;
		this.lastModifiedDate = lastModifiedDate;
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

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
