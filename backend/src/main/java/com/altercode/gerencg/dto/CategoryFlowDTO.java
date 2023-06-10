package com.altercode.gerencg.dto;

import java.io.Serial;
import java.io.Serializable;

import com.altercode.gerencg.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryFlowDTO implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Long addedProducts;
	private Long removedProducts;


	public CategoryFlowDTO(Category category, Long addedProducts, Long removedProducts) {
		categoryName = category.getName();
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
	}
}
