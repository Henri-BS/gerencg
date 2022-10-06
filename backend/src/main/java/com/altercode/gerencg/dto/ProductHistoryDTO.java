package com.altercode.gerencg.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.altercode.gerencg.entity.ProductHistory;

public class ProductHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long product;
	private String description;
	private String image;
	private Double price;
	private Integer quantity;
	private LocalDate validate;
	private LocalDateTime createdDate;
	
	private ProductDTO productDTO;
	
	public ProductHistoryDTO() {
	}

	public ProductHistoryDTO(Long product, String description, String image, Double price, Integer quantity,
			LocalDate validate, LocalDateTime createdDate, ProductDTO productDTO) {
		this.product = product;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.validate = validate;
		this.createdDate = createdDate;
		this.productDTO = productDTO;
	}



	public ProductHistoryDTO(ProductHistory entity) {
		product = entity.getProduct().getId();
		description = entity.getDescription();
		image = entity.getImage();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		createdDate = entity.getCreatedDate();
		productDTO = new ProductDTO(entity.getProduct());
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


	public Long getProduct() {
		return product;
	}


	public void setProduct(Long product) {
		this.product = product;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public ProductDTO getProductDTO() {
		return productDTO;
	}


	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	
	
}
