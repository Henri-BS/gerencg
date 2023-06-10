package com.altercode.gerencg.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String description;

    private String image;

    private Double price;

    private Integer quantity;

    private LocalDate validate;

    private Double income = 0.0;

    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

    @Column(name = "measure_value")
    private Double measureValue;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private Measure measure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private final Set<ProductHistory> history = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private final Set<OrderItem> orderItems = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String description, String image, Double price, Integer quantity, LocalDate validate,
                   Measure measure, Category category) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.validate = validate;
        this.measure = measure;
        this.category = category;
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

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Set<ProductHistory> getAllHistory() {
        return history;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }
}
