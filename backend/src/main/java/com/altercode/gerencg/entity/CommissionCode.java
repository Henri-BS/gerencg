package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_commission_code")
public class CommissionCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Long id;

    @Column(name ="commission_code")
    private String code;

    @OneToMany(mappedBy = "code", cascade = CascadeType.REMOVE)
    private List<Commission> commissions = new ArrayList<>();

    public CommissionCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
