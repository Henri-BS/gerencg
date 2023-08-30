package com.altercode.gerencg.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import com.altercode.gerencg.entity.ProductHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductHistoryDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private String productDescription;
	private Double price;
	private Integer quantity;
	private LocalDate validate;
	private Double income;
	private LocalDate dateCreated;

	public ProductHistoryDTO(ProductHistory entity) {
		id = entity.getId();
		productId = entity.getProduct().getId();
		productDescription = entity.getProduct().getDescription();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		validate = entity.getValidate();
		income = entity.getIncome();
		dateCreated = entity.getDateCreated();
	}
}