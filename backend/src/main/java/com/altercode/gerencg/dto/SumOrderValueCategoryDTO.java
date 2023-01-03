package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Category;

import java.io.Serializable;

public class SumOrderValueCategoryDTO implements Serializable {
    private String categoryName;
    private Double totalValue;

    public SumOrderValueCategoryDTO() {
    }

    public SumOrderValueCategoryDTO(Category category, Double totalValue) {
        categoryName = category.getName();
        this.totalValue = totalValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
