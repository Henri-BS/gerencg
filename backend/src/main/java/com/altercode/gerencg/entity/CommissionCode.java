package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_commission_code")
public class CommissionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String code;

    @OneToMany(mappedBy = "code", cascade = CascadeType.ALL)
    private final Set<Commission> commissions = new HashSet<>();

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

    public Set<Commission> getCommissions() {
        return commissions;
    }
}
