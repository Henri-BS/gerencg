package com.altercode.gerencg.service.interfaceservice;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Tag;

import java.util.List;

public interface IOrderTagService {
    List<OrderTagDTO> findAll();

    List<OrderTagDTO> findAllByTag(Tag tag);

    List<OrderTagDTO> findAllByCode(OrderCode orderCode);

    OrderTagDTO findOrderTagById(Long id);
}
