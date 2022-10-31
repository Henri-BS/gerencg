package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Order;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String orderCode;
    private LocalDate orderDate;
    private Double totalValue;
    private Integer quantity;
    private String distributor;
    private Long product;

    public OrderDTO() {
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        orderCode = entity.getOrderCode();
        orderDate = entity.getOrderDate();
        totalValue = entity.getTotalValue();
        quantity = entity.getQuantity();
        distributor = entity.getDistributor();
        product = entity.getProduct().getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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
