package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderTag;

public class OrderTagDTO {

    private Long id;
    private String codeId;
    private String tagId;

    public OrderTagDTO(OrderTag entity) {
        id = entity.getId();
        codeId = entity.getCode().getCode();
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
