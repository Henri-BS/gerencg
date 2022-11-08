package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionCode;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionCodeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
private LocalDate commissionDate;
private String distributor;

    public CommissionCodeDTO() {
    }

    public CommissionCodeDTO(CommissionCode entity) {
        code = entity.getCode();
        commissionDate = entity.getCommissionDate();
        distributor = entity.getDistributor();
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
}
