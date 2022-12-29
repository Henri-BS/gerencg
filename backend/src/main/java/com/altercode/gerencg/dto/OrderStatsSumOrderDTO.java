package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderStats;

import java.io.Serializable;

public class OrderStatsSumOrderDTO implements Serializable {
    private String statsId;
    private Long amountOrders;

    public OrderStatsSumOrderDTO(OrderStats stats, Long amountOrders) {
        statsId = stats.getId();
        this.amountOrders = amountOrders;
    }

    public String getStatsId() {
        return statsId;
    }

    public void setStatsId(String statsId) {
        this.statsId = statsId;
    }

    public Long getAmountOrders() {
        return amountOrders;
    }

    public void setAmountOrders(Long amountOrders) {
        this.amountOrders = amountOrders;
    }
}
