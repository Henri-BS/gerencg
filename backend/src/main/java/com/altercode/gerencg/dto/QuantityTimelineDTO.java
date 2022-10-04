package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.Product;

public class QuantityTimelineDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long product;
	private Integer quantity;
	private LocalDateTime date;

	

	public QuantityTimelineDTO() {
	}

	public QuantityTimelineDTO(Product product, Integer quantity, LocalDateTime date) {
		this.product = product.getId();
		this.quantity = quantity;
		this.date = date;

	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}	
}
