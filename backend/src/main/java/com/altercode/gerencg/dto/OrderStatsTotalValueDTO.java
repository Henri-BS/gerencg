package com.altercode.gerencg.dto;


public class OrderStatsTotalValueDTO {
    private String statsId;
    private Double totalValue;
    private Double maxValue;
    private Long amountOrders;
    private Long amountItems;

    public OrderStatsTotalValueDTO(Double totalValue, Double maxValue) {
        this.totalValue = totalValue;
        this.maxValue = maxValue;
    }

    public OrderStatsTotalValueDTO(Double totalValue, Double maxValue, Long amountOrders, Long amountItems) {
        this.totalValue = totalValue;
        this.maxValue = maxValue;
        this.amountOrders = amountOrders;
        this.amountItems = amountItems;
    }

    public String getStatsId() {
        return statsId;
    }

    public void setStatsId(String statsId) {
        this.statsId = statsId;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Long getAmountOrders() {
        return amountOrders;
    }

    public void setAmountOrders(Long amountOrders) {
        this.amountOrders = amountOrders;
    }

    public Long getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(Long amountItems) {
        this.amountItems = amountItems;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

}

