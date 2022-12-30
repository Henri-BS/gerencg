package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.StatsSumOrderDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
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

    @Query("SELECT new com.altercode.gerencg.dto.StatsSumOrderDTO (obj.id, SUM(obj.amountOrder))" +
            "FROM OrderStats AS obj GROUP BY obj.id")
    public List<StatsSumOrderDTO> getStatsSumOrdersGroup(Sort sort);
}
