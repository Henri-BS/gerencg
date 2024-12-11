package com.altercode.gerencg.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_product_history")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long id;

	private Double price = 0.0;

	private Integer quantity = 0;

	private LocalDate validate;

	private Double income = 0.0;

	@Column(name = "removed_products")
	private Integer removedProducts = 0;

	@Column(name = "date_created")
	private LocalDate dateCreated;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
