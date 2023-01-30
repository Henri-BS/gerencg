package com.altercode.gerencg.entity;

import javax.persistence.*;

@Entity
public class OrderTag {

    @EmbeddedId
    private OrderTagKey id;

    @ManyToOne
    @MapsId("codeId")
    @JoinColumn(name = "code_id")
    private OrderCode code;

    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
