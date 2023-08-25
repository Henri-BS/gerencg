package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.OrderStatsTotalValueDTO;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatsRepository extends JpaRepository<OrderStats, String> {

    @Query("SELECT new com.altercode.gerencg.dto.OrderStatsTotalValueDTO (" +
            "SUM(obj.expense), MAX(obj.expense), SUM(obj.income), MAX(obj.income), " +
            "SUM(amountOrder), SUM(amountItems))" +
            "FROM OrderStats AS obj")
    OrderStatsTotalValueDTO getOrderStatsTotalValue();

    @Query("SELECT new com.altercode.gerencg.dto.OrderStatsTotalValueDTO (obj.id, SUM(obj.amountOrder))" +
            "FROM OrderStats AS obj GROUP BY obj.id ORDER BY obj.initialDate DESC")
    List<OrderStatsTotalValueDTO> sumQuantitiesGroupById();

    @Query("SELECT new com.altercode.gerencg.dto.OrderStatsTotalValueDTO (obj.id, SUM(obj.expense))" +
            "FROM OrderStats AS obj GROUP BY obj.id ORDER BY obj.initialDate DESC")
    List<OrderStatsTotalValueDTO> sumValuesGroupById();
}