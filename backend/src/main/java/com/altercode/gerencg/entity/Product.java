package com.altercode.gerencg.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "product_image")
	private String image;
	
	@Column(name = "product_price")
	private Double price;
	
	@Column(name = "product_quantity")
	private Integer quantity;
	
	@Column(name = "product_validate")
	private LocalDate validate;
	
	@ManyToOne
	@JoinColumn(name = "measure_id")
	private Measure measure;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Register> register = new HashSet<>();
	
	public Product() {
	}

	public Product(Long id, String description, String image, Double price, Integer quantity, LocalDate validate,
			Measure measure, Category category) {
		this.id = id;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.validate = validate;
		this.measure = measure;
		this.category = category;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public LocalDate getValidate() {
		return validate;
	}


	public void setValidate(LocalDate validate) {
		this.validate = validate;
	}


	public Measure getMeasure() {
		return measure;
	}


	public void setMeasure(Measure measure) {
		this.measure = measure;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
}
