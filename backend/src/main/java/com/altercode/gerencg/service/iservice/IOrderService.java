package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderService {
    Page<CommissionDTO> findAllOrders(Pageable pageable);

    CommissionDTO findOrderById(Long id);

    CommissionDTO addOrder(CommissionDTO dto);

    CommissionDTO updateOrder(CommissionDTO dto);

    void deleteOrder(Long id);

    List<CommissionResultsDTO> orderResults();
}
