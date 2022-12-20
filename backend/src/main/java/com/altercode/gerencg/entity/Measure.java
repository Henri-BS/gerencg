package com.altercode.gerencg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tb_measure")
public class Measure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	@Column(name = "abbreviation")
	private String abbreviation;
	
	@Column(name = "measure_description")
	private String description;
	
	@OneToMany(mappedBy = "measure", cascade = CascadeType.ALL)
	private Set<Product> product = new HashSet<>();

	@OneToMany(mappedBy = "packageType", cascade = CascadeType.ALL)
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

	public Set<CommissionCode> getCodes() {
		return codes;
	}

	public void setCodes(Set<CommissionCode> codes) {
		this.codes = codes;
	}
}
