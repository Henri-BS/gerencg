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
    private CommissionItem commissionId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    public CommissionData() {
    }

    public CommissionItem getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(CommissionItem commissionId) {
        this.commissionId = commissionId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
