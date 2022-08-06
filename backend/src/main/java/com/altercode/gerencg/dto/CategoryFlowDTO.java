package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryFlowDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Long addedProduct;
	private Long removedProduct;
	
	
	public CategoryFlowDTO(){}

	public CategoryFlowDTO(Category category, Long addedProduct, Long removedProduct) {
		categoryName = category.getName();
		this.addedProduct = addedProduct;
		this.removedProduct = removedProduct;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getAddedProduct() {
		return addedProduct;
	}

	public void setAddedProduct(Long addedProduct) {
		this.addedProduct = addedProduct;
	}

	public Long getRemovedProduct() {
		return removedProduct;
	}

	public void setRemovedProduct(Long removedProduct) {
		this.removedProduct = removedProduct;
	}



	
		
}
