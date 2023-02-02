package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.altercode.gerencg.entity.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private String image;
	private Double price;
	private Integer quantity;
	private Double income;
	private LocalDate validate;
	private LocalDate lastUpdateDate;
	private Double measureValue;

	private String measure;
	private String category;

	public ProductDTO() {
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		description = entity.getDescription();
		image = entity.getImage();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		income = entity.getIncome();
		lastUpdateDate = entity.getLastUpdateDate();
		measureValue = entity.getMeasureValue();
		measure = entity.getMeasure().getAbbreviation();
		category = entity.getCategory().getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
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

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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

}
