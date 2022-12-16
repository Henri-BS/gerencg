package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_tag")
public class Tag {

    @Id
    private String title;

    @Column(name = "tag_description")
    private String description;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Category> categories;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<CommissionCode> commissions;

    public Tag() {
    }

    public Tag(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

}

