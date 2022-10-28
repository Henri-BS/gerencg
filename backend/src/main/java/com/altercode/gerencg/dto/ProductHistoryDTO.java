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
	private String description;
	private String image;
	private Double price;
	private Integer quantity;
	private LocalDate validate;
	private Double measureValue;
	private String measure;
	private String category;
	private LocalDateTime createdDate;

	public ProductHistoryDTO() {
	}

	public ProductHistoryDTO(ProductHistory entity) {
		productId = entity.getProduct().getId();
		description = entity.getDescription();
		image = entity.getImage();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		measureValue = entity.getMeasureValue();
		measure = entity.getMeasure().getAbbreviation();
		category = entity.getCategory().getName();
		createdDate = entity.getCreatedDate();
	}

	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
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

	public Double getMeasureValue() {
		return measureValue;
	}

	public void setMeasureValue(Double measureValue) {
		this.measureValue = measureValue;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}




}