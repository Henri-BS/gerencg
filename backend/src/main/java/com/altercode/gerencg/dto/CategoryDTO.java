package com.altercode.gerencg.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String image;
	private Integer totalProducts;
	private Integer totalRegisters;
	private LocalDateTime lastModifiedDate;

	public CategoryDTO(Category entity) {
		name = entity.getName();
		image = entity.getImage();
		totalProducts = entity.getTotalProducts();
		totalRegisters = entity.getTotalRegisters();
		lastModifiedDate = entity.getLastModifiedDate();
	}
}
