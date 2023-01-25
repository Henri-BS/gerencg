package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.ProductHistory;

public class ProductHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private Double price;
	private Integer quantity;
	private LocalDate validate;
	private Double income;
	private LocalDate createdDate;

	public ProductHistoryDTO() {
	}

	public ProductHistoryDTO(ProductHistory entity) {
		id = entity.getId();
		productId = entity.getProduct().getId();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		income = entity.getIncome();
		createdDate = entity.getCreatedDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
}