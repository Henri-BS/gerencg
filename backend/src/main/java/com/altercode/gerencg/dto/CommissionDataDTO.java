package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionData;

import java.io.Serializable;

public class CommissionDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long productId;
    private Long itemId;

    public CommissionDataDTO() {
    }

    public CommissionDataDTO(CommissionData entity) {
        productId = entity.getProduct().getId();
        itemId = entity.getCommission().getId();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
