package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionItem;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String commissionCode;
    private Double unitValue;
    private Double totalValue;
    private Integer quantity;
    private Integer packageQuantity;
    private LocalDate itemValidate;

    private Long productId;
    private String productDescription;
    private Double productMeasureValue;
    private String productMeasure;

    public CommissionItemDTO() {
    }

    public CommissionItemDTO(CommissionItem entity) {
        id = entity.getId();
        commissionCode = entity.getCode().getCode();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommissionCode() {
        return commissionCode;
    }

    public void setCommissionCode(String orderCode) {
        this.commissionCode = orderCode;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public LocalDate getItemValidate() {
        return itemValidate;
    }

    public void setItemValidate(LocalDate itemValidate) {
        this.itemValidate = itemValidate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductMeasureValue() {
        return productMeasureValue;
    }

    public void setProductMeasureValue(Double productMeasureValue) {
        this.productMeasureValue = productMeasureValue;
    }

    public String getProductMeasure() {
        return productMeasure;
    }

    public void setProductMeasure(String productMeasure) {
        this.productMeasure = productMeasure;
    }
}
