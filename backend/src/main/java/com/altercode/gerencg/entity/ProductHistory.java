package com.altercode.gerencg.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "tb_product_history")
public class ProductHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long id;

	private String description;

	private String image;

	private Double price;

	private Integer quantity;

	private LocalDate validate;

    @Column(name = "measure_value")
    private Double measureValue;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private Measure measure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate =  LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;


	public ProductHistory() {
	}

    public ProductHistory(Long id, String description, String image, Double price,
                          Integer quantity, LocalDate validate, Double measureValue, Measure measure,
                          Category category, LocalDateTime createdDate, Product product) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.validate = validate;
        this.measureValue = measureValue;
        this.measure = measure;
        this.category = category;
        this.createdDate = createdDate;
        this.product = product;
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

    public Double getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(Double measureValue) {
        this.measureValue = measureValue;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
