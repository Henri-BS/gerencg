package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.OrderCodeDTO;
import com.altercode.gerencg.dto.SumCategoryQuantityDTO;
import com.altercode.gerencg.dto.SumCategoryValueDTO;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderCodeService {
    Page<OrderCodeDTO> findItemsByCode(Pageable pageable, String code);

    OrderCodeDTO findCodeById(String id);

    OrderCodeDTO saveOrder(OrderCodeDTO dto);

    OrderCodeDTO updateOrder(OrderCodeDTO dto);

    void deleteOrder(String id);

    OrderCodeDTO orderTotalValues(OrderCodeDTO dto);

    Page<OrderCodeDTO> findOrdersByStats(Pageable pageable, OrderStats stats);

    List<SumCategoryValueDTO> getOrderValueGroupByCategory();

    List<SumCategoryQuantityDTO> getOrderQuantityGroupByCategory();
}