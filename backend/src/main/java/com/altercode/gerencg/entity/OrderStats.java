package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order_stats")
public class OrderStats {
    @Id
    @Column(name = "stats_id", length = 10)
    private String id;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "final_date")
    private LocalDate finalDate;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "average_week")
    private Double averageWeek;

    @Column(name = "amount_commission")
    private Integer amountCommission;

    @Column(name = "amount_items")
    private Integer amountItems;

    @OneToMany(mappedBy = "stats", cascade = CascadeType.ALL)
    private final Set<OrderCode> codes = new HashSet<>();

    public OrderStats() {
    }

    public OrderStats(String id, LocalDate initialDate, LocalDate finalDate, Double totalValue,
                      Double averageWeek, Integer amountCommission, Integer amountItems) {
        this.id = id;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.totalValue = totalValue;
        this.averageWeek = averageWeek;
        this.amountCommission = amountCommission;
        this.amountItems = amountItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Double getAverageWeek() {
        return averageWeek;
    }

    public void setAverageWeek(Double averageWeek) {
        this.averageWeek = averageWeek;
    }

    public Integer getAmountCommission() {
        return amountCommission;
    }

    public void setAmountCommission(Integer amountCommission) {
        this.amountCommission = amountCommission;
    }

    public Integer getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(Integer amountItems) {
        this.amountItems = amountItems;
    }

    public Set<OrderCode> getCodes() {
        return codes;
    }
}
