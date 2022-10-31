package com.altercode.gerencg.dto;

import java.io.Serializable;


import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.Product;

public class OrderResultsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String productName;
	private String orderCode;
	private Long quantity;


	public OrderResultsDTO() {
	}

	public OrderResultsDTO(Order order, Product product, Long quantity, Double totalValue) {
		productName = product.getDescription();
		orderCode = order.getOrderCode();
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
