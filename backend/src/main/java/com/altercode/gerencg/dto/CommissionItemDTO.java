package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionItem;

import java.io.Serializable;

public class CommissionItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String commissionCode;
    private Double totalValue;
    private Integer quantity;
    private Long product;
    private String productDescription;

    public CommissionItemDTO() {
    }

    public CommissionItemDTO(CommissionItem entity) {
        id = entity.getId();
        commissionCode = entity.getCode().getCode();
        totalValue = entity.getTotalValue();
        quantity = entity.getQuantity();
        product = entity.getProduct().getId();
        productDescription = entity.getProduct().getDescription();
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
}
