package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "code_id")
    private String code;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private String distributor;

    @Column(name = "expense", precision = 12, scale = 2)
    private Double expense = 0.0;

    @Column(name = "income", precision = 12, scale = 2)
    private Double income;

    @Column(name = "total_quantity")
    private Integer totalQuantity = 0;

    @Column(name = "amount_items")
    private Integer amountItems = 0;

    @Column(name = "total_package")
    private Integer totalPackage = 0;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "package_type")
    private Measure packageType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "stats_id")
    private OrderStats stats;

    @OneToMany(mappedBy = "code", cascade = CascadeType.ALL)
    private final Set<OrderItem> items = new HashSet<>();

    @OneToMany( mappedBy = "code", cascade = CascadeType.ALL)
    private Set<OrderTag> orderTags = new HashSet<>();
}