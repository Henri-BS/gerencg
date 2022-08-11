package com.altercode.gerencg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	private Double value;
	private String abbreviation;
	
	@OneToMany(mappedBy = "measure")
	private Set<Product> product = new HashSet<>();
	
	public Measure() {
	}
	
	public Measure(Long id, String description, Double value, String abbreviation, Set<Product> product) {
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	
	
}
