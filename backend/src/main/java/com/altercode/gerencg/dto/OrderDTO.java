package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class OrderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;
    private LocalDate orderDate;
    private String distributor;
    private Double expense;
    private Double income;
    private Integer totalQuantity;
    private Integer totalPackage;
    private String measure;
    private Integer amountItems;
    private String statsId;
    private String categoryId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    public OrderDTO(Order entity) {
        code = entity.getCode();
        orderDate = entity.getOrderDate();
        distributor = entity.getDistributor();
        expense = entity.getExpense();
        income = entity.getIncome();
        totalQuantity = entity.getTotalQuantity();
        amountItems = entity.getAmountItems();
        totalPackage = entity.getTotalPackage();
        measure = entity.getMeasure().getAbbreviation();
        dateCreated = entity.getDateCreated();
        dateUpdated = entity.getDateUpdated();
        statsId = entity.getStats().getId();
        categoryId = entity.getCategory().getName();
    }
}
