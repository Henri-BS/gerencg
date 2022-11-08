package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_commission_code")
public class CommissionCode {

    @Id
    private String code;

    @Column(name = "commission_date")
    private LocalDate commissionDate;

    private String distributor;

    @OneToMany(mappedBy = "code", cascade = CascadeType.ALL)
    private final Set<CommissionItem> commissionItems = new HashSet<>();

    public CommissionCode() {
    }

    public CommissionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCommissionDate() {
        return commissionDate;
    }

    public void setCommissionDate(LocalDate commissionDate) {
        this.commissionDate = commissionDate;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Set<CommissionItem> getCommissions() {
        return commissionItems;
    }


}
