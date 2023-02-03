package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Category;

import java.io.Serializable;

public class SumCategoryValueDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String categoryName;
    private Double value;

    public SumCategoryValueDTO() {
    }

    public SumCategoryValueDTO(Category category, Double value) {
        categoryName = category.getName();
        this.value = Math.round(value *100)/100.00;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
