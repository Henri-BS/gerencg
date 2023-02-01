package com.altercode.gerencg.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_order_tag")
public class OrderTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private OrderCode code;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public OrderTag() {
    }

    public OrderTag(Long id, OrderCode code, Tag tag) {
        this.id = id;
        this.code = code;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
