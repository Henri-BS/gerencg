package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "tag_description")
    private String description;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private Set<OrderTag> orderTags = new HashSet<>();

}

