package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderTagService {
    Page<OrderTagDTO> findAll(Pageable pageable);

    List<OrderTagDTO> findByTag(Tag tag);

    List<OrderTagDTO> findByOrder(Order order);

    OrderTagDTO findOrderTagById(Long id);

    OrderTagDTO saveOrderTag(OrderTagDTO dto);

    void deleteOrderTag(Long id);
}
