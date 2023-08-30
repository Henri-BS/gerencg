package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "cost_value", precision = 7, scale = 2)
    private Double costValue;

    @Column(name = "expense", precision = 12, scale = 2)
    private Double expense = 0.0;

    @Column(name = "unit_value", precision = 7, scale = 2)
    private Double unitValue;

    @Column(name = "income", precision = 12, scale = 2)
    private Double income = 0.0;

    @Column(name = "item_validate")
    private LocalDate itemValidate;

    @Column(name = "package_quantity")
    private Integer packageQuantity;

    @CreatedDate
    @Column(name = "date_created", updatable = false)
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private Order code;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}