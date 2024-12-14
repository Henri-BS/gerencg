package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface OrderService {
    Page<OrderDTO> findOrders(Pageable pageable, String code);

    OrderDTO findOrderById(String id);

    OrderDTO saveOrder(OrderDTO dto);

    OrderDTO updateOrder(OrderDTO dto);

    void deleteOrder(String id);

    OrderDTO orderTotalValues(OrderDTO dto);

    Page<OrderDTO> findOrdersByStats(Pageable pageable, OrderStats stats);

    List<CategoryStatsTotalValueDTO> getOrderValueGroupByCategory();

    List<CategoryStatsTotalValueDTO> getOrderQuantityGroupByCategory();
}