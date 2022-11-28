package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionCode;

import java.io.Serializable;
import java.time.LocalDate;

public class CommissionCodeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private LocalDate commissionDate;
    private String distributor;
    private Double totalValue;
    private Integer totalQuantity;
    private Integer totalPackage;
    private String packageType;
    private Integer amountItems;

    public CommissionCodeDTO() {
    }

    public CommissionCodeDTO(CommissionCode entity) {
        code = entity.getCode();
        commissionDate = entity.getCommissionDate();
        distributor = entity.getDistributor();
        totalValue = entity.getTotalValue();
        totalQuantity = entity.getTotalQuantity();
        amountItems = entity.getAmountItems();
        totalPackage = entity.getTotalPackage();
        packageType = entity.getPackageType().getAbbreviation();
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

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getTotalPackage() {
        return totalPackage;
    }

    public void setTotalPackage(Integer totalPackage) {
        this.totalPackage = totalPackage;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Integer getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(Integer amountItems) {
        this.amountItems = amountItems;
    }
}
