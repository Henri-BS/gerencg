package com.altercod.gerencg.dto;

import java.time.LocalDate;

import com.altercod.gerencg.entities.CategoryStats;

public class DetailDTO {
	private Long id;
	private Integer addedProducts;
	private Integer removedProducts;
	private Double categoryValue;
	private LocalDate registrationDate;
	
	private CategoryDTO category;
	
	public DetailDTO() {}

	public DetailDTO(Long id, Integer addedProducts, Integer removedProducts, Double categoryValue, LocalDate registrationDate,
			CategoryDTO category) {
		this.id = id;
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
		this.categoryValue = categoryValue;
		this.registrationDate = registrationDate;
		this.category = category;
	}
	
	public DetailDTO(CategoryStats entity) {
		id = entity.getId();
		addedProducts = entity.getAddedProducts();
		removedProducts = entity.getRemovedProducts();
		categoryValue = entity.getCategoryValue();
		registrationDate = entity.getRegistrationDate();
		category = new CategoryDTO(entity.getCategory());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProd_adc() {
		return addedProducts;
	}

	public void setProd_adc(Integer prod_adc) {
		this.addedProducts = prod_adc;
	}

	public Integer getProd_remov() {
		return removedProducts;
	}

	public void setProd_remov(Integer prod_remov) {
		this.removedProducts = prod_remov;
	}

	public Double getUpd_val() {
		return categoryValue;
	}

	public void setUpd_val(Double upd_val) {
		this.categoryValue = upd_val;
	}

	public LocalDate getDate() {
		return registrationDate;
	}

	public void setDate(LocalDate date) {
		this.registrationDate = date;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
}
