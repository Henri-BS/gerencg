package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsSumOrderDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderStatsService {

  Page<OrderStatsDTO> findAllStats(Pageable pageable);


    OrderStatsDTO saveOrderStats(OrderStatsDTO dto);

    OrderStatsDTO updateStatsValues(OrderStatsDTO dto);

  OrderStatsValuesDTO getOrderStatsTotalValues();

  OrderStatsDTO findOrderStatsById(String id);

  List<OrderStatsSumOrderDTO> getStatsOrdersGroup();
}
