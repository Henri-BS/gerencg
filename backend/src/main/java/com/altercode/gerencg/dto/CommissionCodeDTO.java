package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.CommissionCode;

import java.io.Serializable;

public class CommissionCodeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    public CommissionCodeDTO() {
    }

    public CommissionCodeDTO(CommissionCode entity) {
        code = entity.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
