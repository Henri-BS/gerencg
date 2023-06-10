package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderStats;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class OrderStatsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Double totalValue;
    private Double averageWeek;
    private Integer amountOrder;
    private Integer amountItems;

    public OrderStatsDTO(OrderStats entity) {
        id = entity.getId();
        initialDate = entity.getInitialDate();
        finalDate = entity.getFinalDate();
        totalValue = entity.getTotalValue();
        averageWeek = entity.getAverageWeek();
        amountOrder = entity.getAmountOrder();
        amountItems = entity.getAmountItems();
    }
}
