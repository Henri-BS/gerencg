package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.OrderResultsDTO;
import com.altercode.gerencg.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

    @Query("SELECT new com.altercode.gerencg.dto.OrderResultsDTO(obj.orderCode, SUM(obj.quantity), SUM(obj.totalValue)) " +
            "FROM Order AS obj GROUP BY obj.orderCode" )
    List<OrderResultsDTO>  orderResults();
}
