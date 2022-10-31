package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IOrderService {
    Page<OrderDTO> findAllOrders(Pageable pageable);
    OrderDTO findOrderById(String id);
    OrderDTO addOrder(OrderDTO dto);
    OrderDTO updateOrder(OrderDTO dto);
    void deleteOrder(String id);
}
