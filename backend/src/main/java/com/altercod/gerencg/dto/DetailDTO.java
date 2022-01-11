package com.altercod.gerencg.dto;

import java.time.LocalDate;

import com.altercod.gerencg.entities.Detail;

public class DetailDTO {
	private Long id;
	private Integer prod_adc;
	private Integer prod_remov;
	private Double upd_val;
	private LocalDate date;
	
	private CategoryDTO category;
	
	public DetailDTO() {}

	public DetailDTO(Long id, Integer prod_adc, Integer prod_remov, Double upd_val, LocalDate date,
			CategoryDTO category) {
		this.id = id;
		this.prod_adc = prod_adc;
		this.prod_remov = prod_remov;
		this.upd_val = upd_val;
		this.date = date;
		this.category = category;
	}
	
	public DetailDTO(Detail entity) {
		id = entity.getId();
		prod_adc = entity.getProd_adc();
		prod_remov = entity.getProd_remov();
		upd_val = entity.getUpd_val();
		date = entity.getDate();
		category = new CategoryDTO(entity.getCategory());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProd_adc() {
		return prod_adc;
	}

	public void setProd_adc(Integer prod_adc) {
		this.prod_adc = prod_adc;
	}

	public Integer getProd_remov() {
		return prod_remov;
	}

	public void setProd_remov(Integer prod_remov) {
		this.prod_remov = prod_remov;
	}

	public Double getUpd_val() {
		return upd_val;
	}

	public void setUpd_val(Double upd_val) {
		this.upd_val = upd_val;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
}
