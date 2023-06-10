package com.altercode.gerencg.dto;

import java.io.Serial;
import java.io.Serializable;

public class CategoryStatsTotalValueDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Double totalValue;
    private Double maxValue;

    public CategoryStatsTotalValueDTO(Double totalValue, Double maxValue) {
        this.totalValue = Math.round(totalValue * 100) / 100.0;
        this.maxValue = maxValue;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
