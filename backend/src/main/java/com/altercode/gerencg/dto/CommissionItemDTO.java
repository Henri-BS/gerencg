package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionItem;

import java.io.Serializable;

public class CommissionItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String commissionCode;
    private Double unitValue;
    private Double totalValue;
    private Integer quantity;
    private Integer packageQuantity;
    private Long product;
    private String productDescription;
    private Double productMeasureValue;
    private String productMeasure;



    public CommissionItemDTO() {
    }

    public CommissionItemDTO(CommissionItem entity) {
        id = entity.getId();
        commissionCode = entity.getCode().getCode();
        unitValue = entity.getUnitValue();
        totalValue = entity.getItemTotalValue();
        quantity = entity.getItemQuantity();
        packageQuantity = entity.getPackageQuantity();
        product = entity.getProduct().getId();
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

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
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
