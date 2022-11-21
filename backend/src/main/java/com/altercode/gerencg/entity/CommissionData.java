package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;

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

    private LocalDate date;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
