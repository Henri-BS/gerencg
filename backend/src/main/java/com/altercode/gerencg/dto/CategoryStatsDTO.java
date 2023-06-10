package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CategoryStats;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CategoryStatsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime lastModifiedDate;
    private Integer addedProducts;
    private Double income;
    private String category;

    public CategoryStatsDTO(CategoryStats entity) {
        id = entity.getId();
        lastModifiedDate = entity.getLastModifiedDate();
        addedProducts = entity.getAddedProducts();
        income = entity.getIncome();
        category = entity.getCategory().getName();
    }
}
