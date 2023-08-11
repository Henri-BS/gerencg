package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name = "tb_category_stats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryStats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "added_products")
	private Integer addedProducts;

	private Double income;

	@Column(name = "max_income")
	private Double maxIncome;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;

}
