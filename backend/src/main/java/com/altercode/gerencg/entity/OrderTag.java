package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order_tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
