package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderStatsDTO;

import java.util.List;

public interface IOrderStatsService {

    List<OrderStatsDTO> findAllStats(String id);

    OrderStatsDTO saveCommissionStats(OrderStatsDTO dto);

    OrderStatsDTO updateStatsValues(OrderStatsDTO dto);
}
