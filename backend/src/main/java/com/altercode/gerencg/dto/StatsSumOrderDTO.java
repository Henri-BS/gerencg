package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderStats;

import java.io.Serializable;

public class OrderStatsSumOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String statsId;
    private Long sumOrders;

    public OrderStatsSumOrderDTO() {
    }

    public OrderStatsSumOrderDTO(String stats, Long amountOrder) {
        statsId = stats;
        this.sumOrders = amountOrder;
    }


    public String getStatsId() {
        return statsId;
    }

    public void setStatsId(String statsId) {
        this.statsId = statsId;
    }

    public Long getSumOrders() {
        return sumOrders;
    }

    public void setSumOrders(Long sumOrders) {
        this.sumOrders = sumOrders;
    }
}
