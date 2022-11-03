package com.altercode.gerencg.dto;

import java.io.Serializable;

import com.altercode.gerencg.entity.Category;

public class CategoryFlowDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String categoryName;
	private Long addedProducts;
	private Long removedProducts;

	public CategoryFlowDTO(){}

	public CategoryFlowDTO(Category category, Long addedProducts, Long removedProducts) {
		categoryName = category.getName();
		this.addedProducts = addedProducts;
		this.removedProducts = removedProducts;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getAddedProduct() {
		return addedProducts;
	}

	public void setAddedProduct(Long addedProduct) {
		this.addedProducts = addedProduct;
	}

	public Long getRemovedProduct() {
		return removedProducts;
	}

	public void setRemovedProduct(Long removedProduct) {
		this.removedProducts = removedProduct;
	}



	
		
}
