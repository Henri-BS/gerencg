package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_commission_code")
public class CommissionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "code_id")
    private String code;

    @OneToMany(mappedBy = "code", cascade = CascadeType.REMOVE)
    private List<Commission> commissions = new ArrayList<>();

    public CommissionCode() {
    }

    public CommissionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Commission> getCommissions() {
        return commissions;
    }

}
