package com.altercode.gerencg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String description;

    private String image;

    private Double price;

    private Integer quantity;

    private LocalDate validate;

    private Double income = 0.0;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @Column(name = "measure_value")
    private Double measureValue;

    @ManyToOne
    @JoinColumn(name = "measure_id")
    private Measure measure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private final Set<ProductHistory> history = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private final Set<OrderItem> orderItems = new HashSet<>();

}
