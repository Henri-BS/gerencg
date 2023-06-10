package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderItem;
import lombok.AllArgsConstructor;
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
    private String orderCode;
    private Double unitValue;
    private Double totalValue;
    private Integer quantity;
    private Integer packageQuantity;
    private LocalDate itemValidate;

    private Long productId;
    private String productDescription;
    private Double productMeasureValue;
    private String productMeasure;

    public OrderItemDTO(OrderItem entity) {
        id = entity.getId();
        orderCode = entity.getCode().getCode();
        unitValue = entity.getUnitValue();
        totalValue = entity.getTotalValue();
        quantity = entity.getItemQuantity();
        packageQuantity = entity.getPackageQuantity();
        itemValidate = entity.getItemValidate();
        productId = entity.getProduct().getId();
        productDescription = entity.getProduct().getDescription();
        productMeasureValue = entity.getProduct().getMeasureValue();
        productMeasure = entity.getProduct().getMeasure().getAbbreviation();
    }
}