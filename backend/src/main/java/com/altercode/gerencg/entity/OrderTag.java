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
    private OrderCode orderCode;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public OrderTag() {
    }

    public OrderTag(Long id, OrderCode orderCode, Tag tag) {
        this.id = id;
        this.orderCode = orderCode;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderCode getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(OrderCode orderCode) {
        this.orderCode = orderCode;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
