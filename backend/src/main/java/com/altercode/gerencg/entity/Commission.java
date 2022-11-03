package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_commission")
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long id;

    @Column(name = "commission_date")
    private LocalDate orderDate;

    @Column(name = "total_value")
    private Double totalValue;

    private Integer quantity;

    private String distributor;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private CommissionCode code;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Commission() {
    }

    public Commission(Long id, CommissionCode code, LocalDate orderDate, Double totalValue, Integer quantity, String distributor, Product product) {
        this.id = id;
        this.code = code;
        this.orderDate = orderDate;
        this.totalValue = totalValue;
        this.quantity = quantity;
        this.distributor = distributor;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommissionCode getCode() {
        return code;
    }

    public void setCode(CommissionCode code) {
        this.code = code;
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