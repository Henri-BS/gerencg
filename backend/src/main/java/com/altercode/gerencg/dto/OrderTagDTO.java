package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderTag;

public class OrderTagDTO {

    private Long id;
    private String code;
    private String tag;

    public OrderTagDTO(OrderTag entity) {
        id = entity.getId();
        code = entity.getOrderCode().getCode();
        tag = entity.getTag().getTagId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
