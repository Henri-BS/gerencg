package com.altercode.gerencg.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_commission_item")
public class CommissionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long id;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_value")
    private Double unitValue;

    @Column(name = "package_quantity")
    private Integer packageQuantity;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private CommissionCode code;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CommissionItem() {
    }

    public CommissionItem(Long id, Double totalValue, Integer quantity, Double unitValue, Integer packageQuantity, CommissionCode code, Product product) {
        this.id = id;
        this.totalValue = totalValue;
        this.quantity = quantity;
        this.unitValue = unitValue;
        this.packageQuantity = packageQuantity;
        this.code = code;
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

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public Integer getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(Integer packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}