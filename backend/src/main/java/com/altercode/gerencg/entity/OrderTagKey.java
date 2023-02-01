package com.altercode.gerencg.entity;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderTagKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private OrderCode code;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public OrderTagKey() {}

    public OrderCode getCode() {
        return code;
    }

    public void setCode(OrderCode code) {
        this.code = code;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
