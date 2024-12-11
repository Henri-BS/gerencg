package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsTotalValueDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderStatsService {

  Page<OrderStatsDTO> findAllStats(Pageable pageable);


    OrderStatsDTO saveOrderStats(OrderStatsDTO dto);

    OrderStatsDTO updateOrderStats(OrderStatsDTO dto);

    OrderStatsDTO updateStatsValues(OrderStatsDTO dto);

  OrderStatsTotalValueDTO getOrderStatsTotalValues();

  OrderStatsDTO findOrderStatsById(String id);

  List<OrderStatsTotalValueDTO> getOrderStatsQuantityGroup();

  List<OrderStatsTotalValueDTO> getOrderStatsValueGroup();

  void deleteOrderStats(String id);
}
