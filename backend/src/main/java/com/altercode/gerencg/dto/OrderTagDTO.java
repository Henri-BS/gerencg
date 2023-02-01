package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderTag;

public class OrderTagDTO {

    private Long id;
    private String code;
    private String tag;

    public OrderTagDTO(String code, String tag) {
        this.code = code;
        this.tag = tag;
    }

    public OrderTagDTO(OrderTag entity) {
        code = entity.getOrderCode().getCode();
        tag = entity.getTag().getTagId();
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
