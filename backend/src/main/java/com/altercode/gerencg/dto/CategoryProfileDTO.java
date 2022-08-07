package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.Category;

public class CategoryProfileDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String image;
	private Integer totalProducts;
	private LocalDateTime lastModifiedDate;
	
	public CategoryProfileDTO() {}
	
	public CategoryProfileDTO(Long id, String name, String image, 
			Integer totalProducts, Double expense, Double income,
			LocalDateTime lastModifiedDate) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.totalProducts = totalProducts;
		this.lastModifiedDate = lastModifiedDate;
	}

	public CategoryProfileDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
		image = entity.getImage();
		totalProducts = entity.getTotalProducts();
		lastModifiedDate = entity.getLastModifiedDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
}
