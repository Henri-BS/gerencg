package com.altercode.gerencg.dto;

public class OrderTagDTO {

    private String code;
    private String tag;

    public OrderTagDTO(String code, String tag) {
        this.code = code;
        this.tag = tag;
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
