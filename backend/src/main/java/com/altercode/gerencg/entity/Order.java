package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private String id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_value")
    private Double totalValue;

    private Integer quantity;

    private String distributor;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order() {
    }

    public Order(String id, String orderCode, LocalDate orderDate, Double totalValue, Integer quantity, String distributor, Product product) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
        this.quantity = quantity;
        this.distributor = distributor;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
