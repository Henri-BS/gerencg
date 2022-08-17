package com.altercode.gerencg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_calculator")
public class Calculator {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;
	
	private Product firstProduct;
	private Product secondProduct;
	private Double result;

	public Calculator() {
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
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

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

}
