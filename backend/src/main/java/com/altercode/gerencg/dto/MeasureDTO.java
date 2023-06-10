package com.altercode.gerencg.dto;

import java.io.Serial;
import java.io.Serializable;

import com.altercode.gerencg.entity.Measure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MeasureDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String description;
	private String abbreviation;

	public MeasureDTO(Measure entity) {
		description = entity.getDescription();
		abbreviation = entity.getAbbreviation();
	}
}
