package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

import static org.hibernate.annotations.CascadeType.REFRESH;

@Entity
@Table(name = "tb_order_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "quantity")
    private Integer itemQuantity;

    @Column(name = "unit_value")
    private Double unitValue;

    @Column(name = "total_value")
    private Double totalValue;

    @Column(name = "item_validate")
    private LocalDate itemValidate;

    @Column(name = "package_quantity")
    private Integer packageQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({REFRESH})
    @JoinColumn(name = "code_id")
    private OrderCode code;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}