package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Measure;

public class MeasureDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private String description;
	private String abbreviation;

	public MeasureDTO() {
	}

	public MeasureDTO(Measure entity) {
		description = entity.getDescription();
		abbreviation = entity.getAbbreviation();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}	
}
