package com.altercode.gerencg.dto;

import java.io.Serializable;

public class SumValueOrderDTO implements Serializable  {
    private String date;
    private Double value;

    public SumValueOrderDTO(String date, Double value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
