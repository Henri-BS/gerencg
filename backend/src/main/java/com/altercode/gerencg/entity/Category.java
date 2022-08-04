package com.altercode.gerencg.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tb_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
	
	@Column(name = "category_name")
	private String name;
	
	@Column(name = "category_image")
	private String image;
	
	@Column(name = "total_products")
	private Integer totalProducts;
	
	@Column(name = "category_expense")
	private Integer expense;
	
	@Column(name = "category_income")
	private Integer income;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	
	@OneToMany(mappedBy = "category")
	private List<CategoryStats> categoryStats = new ArrayList<>();

	@OneToMany(mappedBy = "category")
	private List<Product> product = new ArrayList<>();
	
	public Category() {
	}

	public Category(Long id, String name, String image, Integer totalProducts, Integer expense, Integer income,
			LocalDateTime lastModifiedDate, List<CategoryStats> categoryStats, List<Product> product) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.totalProducts = totalProducts;
		this.expense = expense;
		this.income = income;
		this.lastModifiedDate = lastModifiedDate;
		this.categoryStats = categoryStats;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

	public Integer getExpense() {
		return expense;
	}

	public void setExpense(Integer expense) {
		this.expense = expense;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public List<CategoryStats> getCategoryStats() {
		return categoryStats;
	}

	public List<Product> getProduct() {
		return product;
	}
	
}
