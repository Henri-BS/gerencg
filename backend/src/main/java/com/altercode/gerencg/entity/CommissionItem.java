package com.altercode.gerencg.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_commission_item")
public class CommissionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long id;

    @Column(name = "quantity")
    private Integer itemQuantity;

    @Column(name = "unit_value")
    private Double unitValue;

    @Column(name = "total_value")
    private Double itemTotalValue;

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

    public CommissionItem(Long id, Double itemTotalValue, Integer itemQuantity, Double unitValue, Integer packageQuantity, CommissionCode code, Product product) {
        this.id = id;
        this.itemTotalValue = itemTotalValue;
        this.itemQuantity = itemQuantity;
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

    public Double getItemTotalValue() {
        return itemTotalValue;
    }

    public void setItemTotalValue(Double itemTotalValue) {
        this.itemTotalValue = itemTotalValue;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
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