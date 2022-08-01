package com.altercod.gerencg.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category_info")
public class CategoryInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String image;
	private Integer total_products;
	private LocalDate last_change;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public CategoryInfo() {}
	
	public CategoryInfo(Long id, String image, Integer total_products, LocalDate last_change, Category category) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
