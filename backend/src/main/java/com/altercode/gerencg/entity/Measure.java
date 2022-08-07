package com.altercode.gerencg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_measure")
public class Measure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "measure_id")
	private Long id;
	
	@Column(name = "measure_description")
	private String description;
	
	private Integer value;
	private String abbreviation;
	
	@OneToOne(mappedBy = "measure")
	private Product product;
	
	public Measure() {
	}
	
	public Measure(Long id, String description, Integer value, String abbreviation, Product product) {
		this.id = id;
		this.description = description;
		this.value = value;
		this.abbreviation = abbreviation;
		this.product = product;
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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
