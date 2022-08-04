package com.altercode.gerencg.dto;

import java.time.LocalDate;

import com.altercode.gerencg.entity.Product;

public class ProductDTO {
		
		private Long id;
		private String description;
		private String image;
		private Double price;
		private Integer quantity;
		private LocalDate validate;
		
		private Long measure;
		private Long category;
		
		
		public ProductDTO() {
		}


		public ProductDTO(Long id, String description, String image, Double price, Integer quantity, LocalDate validate,
				Long measure, Long category) {
			this.id = id;
			this.description = description;
			this.image = image;
			this.price = price;
			this.quantity = quantity;
			this.validate = validate;
			this.measure = measure;
			this.category = category;
		}
		
		public ProductDTO(Product entity) {
			id = entity.getId();
			description = entity.getDescription();
			image = entity.getImage();
			price = entity.getPrice();
			quantity = entity.getQuantity();
			validate = entity.getValidate();
			measure = entity.getMeasure().getId();
			category = entity.getCategory().getId();
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


		public Long getMeasure() {
			return measure;
		}


		public void setMeasure(Long measure) {
			this.measure = measure;
		}


		public Long getCategory() {
			return category;
		}


		public void setCategory(Long category) {
			this.category = category;
		}


}