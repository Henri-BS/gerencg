package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Measure;

public class MeasureDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String description;
	private Double value;
	private String abbreviation;
	

		
	public MeasureDTO() {
	}

	public MeasureDTO(Measure entity) {
		id = entity.getId();
		description = entity.getDescription();
		value = entity.getValue();
		abbreviation = entity.getAbbreviation();
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}	
}
