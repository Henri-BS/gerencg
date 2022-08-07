package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Measure;

public class MeasureDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String description;
	private Integer value;
	private String abbreviation;
	
	private Long productId;
		
	public MeasureDTO() {
	}

	public MeasureDTO(Measure entity) {
		id = entity.getId();
		description = entity.getDescription();
		value = entity.getValue();
		abbreviation = entity.getAbbreviation();
		productId = entity.getProduct().getId();
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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
