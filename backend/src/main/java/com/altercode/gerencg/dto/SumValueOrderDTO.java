package com.altercode.gerencg.dto;

import java.io.Serializable;

public class SumValueOrderDTO implements Serializable  {
    private String statsId;
    private Double value;

    public SumValueOrderDTO(String statsId, Double value) {
        this.statsId = statsId;
        this.value = Math.round(value *100)/100.00;
    }

    public String getStatsId() {
        return statsId;
    }

    public void setStatsId(String statsId) {
        this.statsId = statsId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
