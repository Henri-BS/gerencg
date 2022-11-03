package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;

import java.io.Serializable;

public class CommissionResultsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long productId;
    private String productName;
    private String commissionCode;
    private Long totalQuantity;
    private Double totalValue;

    public CommissionResultsDTO(CommissionCode code, Product product, Long totalQuantity, Double totalValue) {
        commissionCode = code.getCode();
        productName = product.getDescription();
        this.totalQuantity = totalQuantity;
        this.totalValue = totalValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCommissionCode() {
        return commissionCode;
    }

    public void setCommissionCode(String commissionCode) {
        this.commissionCode = commissionCode;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
