package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.Category;

public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String image;
	private Integer totalProducts;
	private Integer totalRegisters;
	private LocalDateTime lastModifiedDate;
	
	public CategoryDTO() {}

	public CategoryDTO(Category entity) {
		name = entity.getName();
		image = entity.getImage();
		totalProducts = entity.getTotalProducts();
		totalRegisters = entity.getTotalRegisters();
		lastModifiedDate = entity.getLastModifiedDate();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}
	
	public Integer getTotalRegisters() {
		return totalRegisters;
	}

	public void setTotalRegisters(Integer totalRegisters) {
		this.totalRegisters = totalRegisters;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
}
