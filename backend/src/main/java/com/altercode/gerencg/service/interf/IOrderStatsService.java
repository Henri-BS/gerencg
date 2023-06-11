package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsTotalValueDTO;
import com.altercode.gerencg.dto.SumQuantityOrderDTO;
import com.altercode.gerencg.dto.SumValueOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderStatsService {

  Page<OrderStatsDTO> findAllStats(Pageable pageable);


    OrderStatsDTO saveOrderStats(OrderStatsDTO dto);

    OrderStatsDTO updateStatsValues(OrderStatsDTO dto);

  OrderStatsTotalValueDTO getOrderStatsTotalValues();

  OrderStatsDTO findOrderStatsById(String id);

  List<SumQuantityOrderDTO> getOrderStatsQuantityGroup();

  List<SumValueOrderDTO> getOrderStatsValueGroup();

}
