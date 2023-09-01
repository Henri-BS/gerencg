package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Category;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CategoryStatsTotalValueDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
private String categoryName;
    private Double totalValue;
    private Double maxValue;
    private Long quantity;

    public CategoryStatsTotalValueDTO(Category category, Double totalValue, Double maxValue, Long quantity) {
        this.categoryName = category.getName();
        this.totalValue = totalValue;
        this.maxValue = maxValue;
        this.quantity = quantity;
    }

    public CategoryStatsTotalValueDTO(Category category, Double totalValue) {
        this.categoryName = category.getName();
        this.totalValue = totalValue;
    }

    public CategoryStatsTotalValueDTO(Double totalValue, Double maxValue) {
        this.totalValue = totalValue;
        this.maxValue = maxValue;
    }

    public CategoryStatsTotalValueDTO(Category category, Long quantity) {
        categoryName = category.getName();
        this.quantity = quantity;
    }

}
