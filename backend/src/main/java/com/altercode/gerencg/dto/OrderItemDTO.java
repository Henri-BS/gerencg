package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderId;
    private Double costValue;
    private Double unitValue;
    private Double expense;
    private Double income;
    private Integer quantity;
    private Integer packageQuantity;
    private LocalDate itemValidate;

    private Long productId;
    private String productDescription;
    private Double productMeasureValue;
    private String productMeasure;

    public OrderItemDTO(OrderItem entity) {
        id = entity.getId();
        orderId = entity.getOrder().getCode();
        costValue = entity.getCostValue();
        unitValue = entity.getUnitValue();
        expense = entity.getExpense();
        income = entity.getIncome();
        quantity = entity.getItemQuantity();
        packageQuantity = entity.getPackageQuantity();
        itemValidate = entity.getItemValidate();
        productId = entity.getProduct().getId();
        productDescription = entity.getProduct().getDescription();
        productMeasureValue = entity.getProduct().getMeasureValue();
        productMeasure = entity.getProduct().getMeasure().getAbbreviation();
    }
}