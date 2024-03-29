package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("SELECT obj FROM Order obj WHERE UPPER(obj.code) " +
            "LIKE UPPER(CONCAT('%', ?1, '%')) " +
            "ORDER BY (obj.orderDate) DESC")
    Page<Order> findOrders(String code, Pageable pageable);

    Page<Order> findOrdersByStats(Pageable pageable, OrderStats stats);

    @Query("SELECT new com.altercode.gerencg.dto.CategoryStatsTotalValueDTO(obj.category, SUM(obj.expense))" +
            "FROM Order AS obj GROUP BY obj.category ORDER BY SUM(obj.expense) DESC")
    List<CategoryStatsTotalValueDTO> getOrderValueGroupByCategory();

    @Query("SELECT new com.altercode.gerencg.dto.CategoryStatsTotalValueDTO(obj.category, SUM(obj.amountItems))" +
            "FROM Order AS obj GROUP BY obj.category ORDER BY SUM(obj.amountItems) DESC")
    List<CategoryStatsTotalValueDTO> getOrderQuantityGroupByCategory();

}