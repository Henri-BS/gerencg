package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderTag;

import java.time.LocalDate;

public class OrderTagDTO {

    private Long id;
    private String codeId;
    private String tagId;
    private LocalDate orderDate;
    private String distributor;
    private String category;

    public OrderTagDTO(OrderTag entity) {
        id = entity.getId();
        codeId = entity.getCode().getCode();
        orderDate = entity.getCode().getOrderDate();
        distributor = entity.getCode().getDistributor();
        category = entity.getCode().getCategory().getName();
        tagId = entity.getTag().getTagId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
