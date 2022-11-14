package com.altercode.gerencg.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_commission_data")
public class CommissionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commission_id")
    private CommissionItem commission;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CommissionData() {
    }

    public CommissionItem getCommission() {
        return commission;
    }

    public void setCommission(CommissionItem commission) {
        this.commission = commission;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
