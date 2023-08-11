package com.altercode.gerencg.dto;

public class SumQuantityOrderDTO  {

    private String statsId;
    private Long sumOrders;

    public SumQuantityOrderDTO(String stats, Long amountOrder) {
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
