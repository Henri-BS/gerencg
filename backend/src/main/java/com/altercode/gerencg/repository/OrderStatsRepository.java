package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatsRepository extends JpaRepository<OrderStats,  String> {

    @Query("SELECT new com.altercode.gerencg.dto.OrderStatsValuesDTO (SUM(obj.totalValue), MAX(obj.totalValue), SUM(amountOrder), SUM(amountItems))" +
            "FROM OrderStats AS obj")
    public OrderStatsValuesDTO statsTotalValues();

}
