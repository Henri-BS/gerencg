package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tag")
public class Tag {

    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "tag_description")
    private String description;

    @ManyToMany(
            mappedBy = "tags", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private Set<OrderCode> orders = new HashSet<>();

    public Tag() {
    }

    public Tag(String tagId, String description) {
        this.tagId = tagId;
        this.description = description;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

