package com.altercode.gerencg.entity;

import com.altercode.gerencg.dto.CommissionCodeDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tag")
public class Tag {

    @Id
    private String title;

    private String abbreviation;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Category> categories;

@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
private Set<CommissionCode> commissions;

    public Tag() {
    }

    public Tag(String title, String abbreviation) {
        this.title = title;
        this.abbreviation = abbreviation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Set<Category> getCategories() {
        return categories;
    }

}

