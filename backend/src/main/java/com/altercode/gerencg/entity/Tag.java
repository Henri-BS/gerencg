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

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private Set<OrderTag> orderTags = new HashSet<>();

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

    public Set<OrderTag> getOrderTags() {
        return orderTags;
    }

    public void setOrderTags(Set<OrderTag> orderTags) {
        this.orderTags = orderTags;
    }
}

