package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private Double expense = 0.0;

    @Column(name = "expense_average_week")
    private Double expenseAverageWeek = 0.0;

    private Double income;

    @Column(name = "income_average_week")
    private Double incomeAverageWeek = 0.00;

    @Column(name = "amount_order")
    private Integer amountOrder = 0;

    @Column(name = "amount_items")
    private Integer amountItems = 0;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated = LocalDateTime.now();

    @OneToMany(mappedBy = "stats", cascade = CascadeType.ALL)
    private final Set<Order> codes = new HashSet<>();
}
