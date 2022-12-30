package com.altercode.gerencg.dto;

import java.io.Serializable;

public class StatsSumOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String statsId;
    private Long sumOrders;

    public StatsSumOrderDTO() {
    }

    public StatsSumOrderDTO(String stats, Long amountOrder) {
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
