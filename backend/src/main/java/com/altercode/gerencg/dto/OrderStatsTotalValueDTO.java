package com.altercode.gerencg.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatsTotalValueDTO {
    private String statsId;
    private Double sumExpense;
    private Double maxExpense;
    private Double sumIncome;
    private Double maxIncome;
    private Long amountOrders;
    private Long amountItems;

    public OrderStatsTotalValueDTO(String statsId, Double sumExpense){
        this.statsId = statsId;
        this.sumExpense = sumExpense;
    }

    public OrderStatsTotalValueDTO(String statsId, Long amountOrders){
        this.statsId = statsId;
        this.amountOrders = amountOrders;
    }

    public OrderStatsTotalValueDTO(Double sumExpense, Double maxExpense) {
        this.sumExpense = sumExpense;
        this.maxExpense = maxExpense;
    }

    public OrderStatsTotalValueDTO(Double sumExpense, Double maxExpense, Double sumIncome, Double maxIncome, Long amountOrders, Long amountItems) {
        this.sumExpense = sumExpense;
        this.maxExpense = maxExpense;
        this.sumIncome = sumIncome;
        this.maxIncome = maxIncome;
        this.amountOrders = amountOrders;
        this.amountItems = amountItems;
    }
}

