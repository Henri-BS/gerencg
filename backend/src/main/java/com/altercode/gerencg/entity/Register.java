package com.altercode.gerencg.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "tb_register")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "register_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "first_product")
	private Product firstProduct;
	
	@ManyToOne
	@JoinColumn(name = "second_product")
	private Product secondProduct;

	@Column(name = "value")
	private Double value;
	
	@OneToMany(mappedBy = "register")
	private Set<Calculator> calculators = new HashSet<>();

	
	public Register() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Product getFirstProduct() {
		return firstProduct;
	}

	public void setFirstProduct(Product firstProduct) {
		this.firstProduct = firstProduct;
	}

	public Product getSecondProduct() {
		return secondProduct;
	}

	public void setSecondProduct(Product secondProduct) {
		this.secondProduct = secondProduct;
	}

	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	} 
	
	

}
