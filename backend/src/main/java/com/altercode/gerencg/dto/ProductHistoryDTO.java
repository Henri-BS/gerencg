package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.ProductHistory;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long productId;
	private Double price;
	private Integer quantity;
	private LocalDate validate;
	private LocalDateTime createdDate;

	public ProductHistoryDTO() {
	}

	public ProductHistoryDTO(ProductHistory entity) {
		productId = entity.getProduct().getId();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		createdDate = entity.getCreatedDate();
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


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}