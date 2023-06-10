package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class OrderCodeDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;
    private LocalDate orderDate;
    private String distributor;
    private Double totalValue;
    private Integer totalQuantity;
    private Integer totalPackage;
    private String packageType;
    private Integer amountItems;
    private String statsId;
    private String categoryId;

    public OrderCodeDTO(OrderCode entity) {
        code = entity.getCode();
        orderDate = entity.getOrderDate();
        distributor = entity.getDistributor();
        totalValue = entity.getTotalValue();
        totalQuantity = entity.getTotalQuantity();
        amountItems = entity.getAmountItems();
        totalPackage = entity.getTotalPackage();
        packageType = entity.getPackageType().getAbbreviation();
        statsId = entity.getStats().getId();
        categoryId = entity.getCategory().getName();
    }
}
