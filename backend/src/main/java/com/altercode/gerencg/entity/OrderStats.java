package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order_stats")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderStats {
    @Id
    @Column(name = "stats_id", length = 10)
    private String id;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "final_date")
    private LocalDate finalDate;

    @Column(name = "total_value")
    private Double totalValue = 0.00;

    @Column(name = "average_week")
    private Double averageWeek = 0.00;

    @Column(name = "amount_order")
    private Integer amountOrder = 0;

    @Column(name = "amount_items")
    private Integer amountItems = 0;

    @OneToMany(mappedBy = "stats", cascade = CascadeType.ALL)
    private final Set<OrderCode> codes = new HashSet<>();
}
