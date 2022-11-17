package com.altercode.gerencg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_measure")
public class Measure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	@Column(name = "abbreviation")
	private String abbreviation;
	
	@Column(name = "measure_description")
	private String description;
	
	@OneToMany(mappedBy = "measure")
	private Set<Product> product = new HashSet<>();

	@OneToMany(mappedBy = "code")
	private Set<CommissionCode> codes = new HashSet<>();
	
	public Measure() {
	}
	
	public Measure(String abbreviation, String description, Set<Product> product) {
		this.abbreviation = abbreviation;
		this.description = description;
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
