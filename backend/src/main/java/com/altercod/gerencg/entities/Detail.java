package com.altercod.gerencg.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Classe contendo os dados referentes as informações de cada uma das categorias. 
 * Long id: identificação das categorias; 
 * int prod_adc: quantidade de produtos que foram adicionados na categoria até determinada data; 
 * int prod_remov: quantidade de produtos que foram removidos da categoria até determinada data; 
 * upd_val: valor atual da categoria; 
 * date: data de registro das informações.
 */  

@Entity
@Table(name = "tb_detail")
public class Detail {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private Integer prod_adc;
	private Integer prod_remov;
	private Double upd_val;
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Detail(){}
	
	public Detail(Long id, Integer prod_adc, Integer prod_remov, Double upd_val, LocalDate date, Category category) {
		this.id = id;
		this.prod_adc = prod_adc;
		this.prod_remov = prod_remov;
		this.upd_val = upd_val;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProd_adc() {
		return prod_adc;
	}

	public void setProd_adc(Integer prod_adc) {
		this.prod_adc = prod_adc;
	}

	public Integer getProd_remov() {
		return prod_remov;
	}

	public void setProd_remov(Integer prod_remov) {
		this.prod_remov = prod_remov;
	}

	public Double getUpd_val() {
		return upd_val;
	}

	public void setUpd_val(Double upd_val) {
		this.upd_val = upd_val;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
