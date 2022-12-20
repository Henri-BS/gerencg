package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionStats;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionStatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        private String id;

        private LocalDate initialDate;

        private LocalDate finalDate;

        private Double totalValue;

        private Integer amountCommission;

        private Integer amountItems;

    public CommissionStatsDTO() {
    }

    public CommissionStatsDTO(CommissionStats entity) {
        id = entity.getId();
        initialDate = entity.getInitialDate();
        finalDate = entity.getFinalDate();
        totalValue = entity.getTotalValue();
        amountCommission = entity.getAmountCommission();
        amountItems = entity.getAmountItems();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getAmountCommission() {
        return amountCommission;
    }

    public void setAmountCommission(Integer amountCommission) {
        this.amountCommission = amountCommission;
    }

    public Integer getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(Integer amountItems) {
        this.amountItems = amountItems;
    }
}
