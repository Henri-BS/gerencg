package com.altercode.gerencg.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tb_category_info")
public class CategoryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String image;
	
	@Column(name = "total_products")
	private Integer totalProducts;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public CategoryInfo() {}
	
	public CategoryInfo(Long id, String image, Integer totalProducts, LocalDateTime lastModifiedDate, Category category) {
		this.id = id;
		this.image = image;
		this.totalProducts = totalProducts;
		this.lastModifiedDate = lastModifiedDate;
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

	public Integer getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Integer totalProducts) {
		this.totalProducts = totalProducts;
	}

	public LocalDateTime getCreatedDate() {
		return lastModifiedDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.lastModifiedDate = createdDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
