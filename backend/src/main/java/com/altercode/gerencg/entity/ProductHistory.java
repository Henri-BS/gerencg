package com.altercode.gerencg.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "tb_product_history")
public class ProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long id;

	private Double price;

	private Integer quantity;

	private LocalDate validate;

	private Double income = 0.0;

	@Column(name = "removed_products")
	private Integer removedProducts = 0;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public ProductHistory() {
	}

	public ProductHistory(Long id, Double price, Integer quantity, LocalDate validate, Double income, Integer removedProducts, LocalDate createdDate, Product product) {
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.validate = validate;
		this.income = income;
		this.removedProducts = removedProducts;
		this.createdDate = createdDate;
		this.product = product;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public LocalDate getValidate() {
		return validate;
	}

	public void setValidate(LocalDate validate) {
		this.validate = validate;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getRemovedProducts() {
		return removedProducts;
	}

	public void setRemovedProducts(Integer removedProducts) {
		this.removedProducts = removedProducts;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
