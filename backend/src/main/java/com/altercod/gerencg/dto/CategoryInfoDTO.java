package com.altercod.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CategoryInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
		
	private String image;
	private Integer total_products;
	private LocalDate last_change;
	
	private CategoryDTO category;
	
	
	public CategoryInfoDTO() {}
	
	public CategoryInfoDTO(Long id, String image, Integer total_products, LocalDate last_change, CategoryDTO category) {
		this.id = id;
		this.image = image;
		this.total_products = total_products;
		this.last_change = last_change;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getTotal_products() {
		return total_products;
	}

	public void setTotal_products(Integer total_products) {
		this.total_products = total_products;
	}

	public LocalDate getLast_change() {
		return last_change;
	}

	public void setLast_change(LocalDate last_change) {
		this.last_change = last_change;
	}

	public CategoryDTO getCategoryDTO() {
		return category;
	}

	public void setCategoryDTO(CategoryDTO category) {
		this.category = category;
	}
}
