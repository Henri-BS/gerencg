package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order_code")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderCode {

    @Id
    @Column(name = "code_id")
    private String code;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private String distributor;

    @Column(name = "total_value")
    private Double totalValue = 0.0;

    @Column(name = "total_quantity")
    private Integer totalQuantity = 0;

    @Column(name = "amount_items")
    private Integer amountItems = 0;

    @Column(name = "total_package")
    private Integer totalPackage = 0;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

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