package com.altercode.gerencg.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

import static org.hibernate.annotations.CascadeType.REFRESH;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "quantity")
    private Integer itemQuantity;

    @Column(name = "unit_value")
    private Double unitValue;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "item_validate")
    private LocalDate itemValidate;

    @Column(name = "package_quantity")
    private Integer packageQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({REFRESH})
    @JoinColumn(name = "code_id")
    private OrderCode code;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Long id, Double totalValue, Integer itemQuantity, Double unitValue, LocalDate itemValidate, Integer packageQuantity, OrderCode code, Product product) {
        this.id = id;
        this.totalValue = totalValue;
        this.itemQuantity = itemQuantity;
        this.unitValue = unitValue;
        this.itemValidate = itemValidate;
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

    public OrderCode getCode() {
        return code;
    }

    public void setCode(OrderCode code) {
        this.code = code;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
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

    public LocalDate getItemValidate() {
        return itemValidate;
    }

    public void setItemValidate(LocalDate itemValidate) {
        this.itemValidate = itemValidate;
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