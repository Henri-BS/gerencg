package com.altercode.gerencg.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order_code")
public class OrderCode {

    @Id
    @Column(name = "code_id")
    private String code;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private String distributor;

    @Column(name = "total_value", precision = 12, scale = 2)
    private Double totalValue = 0.0;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @Column(name = "amount_items")
    private Integer amountItems;

    @Column(name = "total_package")
    private Integer totalPackage;

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

    public OrderCode() {
    }

    public OrderCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getTotalPackage() {
        return totalPackage;
    }

    public void setTotalPackage(Integer totalPackage) {
        this.totalPackage = totalPackage;
    }

    public Integer getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(Integer amountItems) {
        this.amountItems = amountItems;
    }

    public Measure getPackageType() {
        return packageType;
    }

    public void setPackageType(Measure packageType) {
        this.packageType = packageType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public OrderStats getStats() {
        return stats;
    }

    public void setStats(OrderStats stats) {
        this.stats = stats;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Set<OrderTag> getOrderTags() {
        return orderTags;
    }

    public void setOrderTags(Set<OrderTag> orderTags) {
        this.orderTags = orderTags;
    }

}