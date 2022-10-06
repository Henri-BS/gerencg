package com.altercode.gerencg.dto;

import java.io.Serializable;


import com.altercode.gerencg.entity.Product;

public class QuantityTimelineDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String productName;
	private Long sum;


	public QuantityTimelineDTO() {
	}

	public QuantityTimelineDTO(Product product, Long sum) {
		productName = product.getDescription();
		this.sum = sum;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
