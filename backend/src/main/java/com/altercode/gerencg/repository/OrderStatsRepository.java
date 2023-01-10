package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.SumQuantityOrderDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import com.altercode.gerencg.dto.SumValueOrderDTO;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatsRepository extends JpaRepository<OrderStats, String> {

    @Query("SELECT new com.altercode.gerencg.dto.OrderStatsValuesDTO (SUM(obj.totalValue), MAX(obj.totalValue), SUM(amountOrder), SUM(amountItems))" +
            "FROM OrderStats AS obj")
    public OrderStatsValuesDTO getOrderStatsTotalValues();

    @Query("SELECT new com.altercode.gerencg.dto.SumQuantityOrderDTO (obj.id, SUM(obj.amountOrder))" +
            "FROM OrderStats AS obj GROUP BY obj.id ORDER BY obj.initialDate DESC")
    public List<SumQuantityOrderDTO> getSumOrderStatsGroup(Sort sort);

    @Query("SELECT new com.altercode.gerencg.dto.SumValueOrderDTO (obj.id, SUM(obj.totalValue))" +
            "FROM OrderStats AS obj GROUP BY obj.id ORDER BY obj.initialDate DESC")
    public List<SumValueOrderDTO> getSumValuesStats(Sort sort);
}
