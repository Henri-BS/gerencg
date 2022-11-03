package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Commission;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String commissionCode;
    private LocalDate orderDate;
    private Double totalValue;
    private Integer quantity;
    private String distributor;
    private Long product;

    public CommissionDTO() {
    }

    public CommissionDTO(Commission entity) {
        id = entity.getId();
        commissionCode = entity.getCode().getCode();
        orderDate = entity.getOrderDate();
        totalValue = entity.getTotalValue();
        quantity = entity.getQuantity();
        distributor = entity.getDistributor();
        product = entity.getProduct().getId();
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
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

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
