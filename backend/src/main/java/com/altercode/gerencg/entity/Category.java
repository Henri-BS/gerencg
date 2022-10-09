package com.altercode.gerencg.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tb_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "category_name")
	private String name;
	
	@Column(name = "category_image")
	private String image;
	
	@Column(name = "total_products")
	private Integer totalProducts = 1;
	
	@Column(name = "total_registers")
	private Integer totalRegisters = 1;
	
	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	
	@OneToMany(mappedBy = "category")
	private List<CategoryStats> categoryStats = new ArrayList<>();
	
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	
	public Category() {
	}

	public Category( String name, String image, Integer totalProducts,
			LocalDateTime lastModifiedDate) {
		this.name = name;
		this.image = image;
		this.totalProducts = totalProducts;
		this.lastModifiedDate = lastModifiedDate;
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

	public List<CategoryStats> getCategoryStats() {
		return categoryStats;
	}

	public List<Product> getProducts() {
		return products;
	}

	public Integer getTotalRegisters() {
		return totalRegisters;
	}

	public void setTotalRegisters(Integer totalRegisters) {
		this.totalRegisters = totalRegisters;
	}
	
	
}
