package com.altercode.gerencg.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "tb_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "category_name")
	private String name;
	
	@Column(name = "category_image")
	private String image;
	
	@Column(name = "total_products")
	private Integer totalProducts = 1;
	
	@Column(name = "total_registers")
	private Integer totalRegisters = 1;
	
	@Column(name = "date_created")
	private LocalDateTime dateCreated;

	@Column(name = "date_updated")
	private LocalDateTime dateUpdated = LocalDateTime.now();

	@OneToOne(mappedBy = "category")
	private CategoryStats categoryStats;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Order> codes = new ArrayList<>();

}
