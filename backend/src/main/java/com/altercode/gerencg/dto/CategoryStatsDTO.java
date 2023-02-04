package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CategoryStats;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CategoryStatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime lastModifiedDate;
    private Integer addedProducts;
    private Double income;
    private String category;

    public CategoryStatsDTO(Long id, LocalDateTime lastModifiedDate, Integer addedProducts, Integer removedProducts,
                            Double income, String category) {
        this.id = id;
        this.lastModifiedDate = lastModifiedDate;
        this.addedProducts = addedProducts;
        this.income = income;
        this.category = category;
    }

    public CategoryStatsDTO(CategoryStats entity) {
        id = entity.getId();
        lastModifiedDate = entity.getLastModifiedDate();
        addedProducts = entity.getAddedProducts();
        income = entity.getIncome();
        category = entity.getCategory().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAddedProducts() {
        return addedProducts;
    }

    public void setAddedProducts(Integer addedProducts) {
        this.addedProducts = addedProducts;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
