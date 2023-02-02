package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Category;

import java.io.Serializable;

public class SumOrderQuantityCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String categoryName;
    private Long quantity;

    public SumOrderQuantityCategoryDTO(Category category, Long quantity) {
        categoryName = category.getName();
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
