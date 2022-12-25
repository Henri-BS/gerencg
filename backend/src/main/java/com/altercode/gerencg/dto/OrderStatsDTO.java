package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderStats;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderStatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

        private String id;

        private LocalDate initialDate;

        private LocalDate finalDate;

        private Double totalValue;

        private Double averageWeek;

        private Integer amountCommission;

        private Integer amountItems;

    public OrderStatsDTO() {
    }

    public OrderStatsDTO(OrderStats entity) {
        id = entity.getId();
        initialDate = entity.getInitialDate();
        finalDate = entity.getFinalDate();
        totalValue = entity.getTotalValue();
        averageWeek = entity.getAverageWeek();
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

    public Double getAverageWeek() {
        return averageWeek;
    }

    public void setAverageWeek(Double averageWeek) {
        this.averageWeek = averageWeek;
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
