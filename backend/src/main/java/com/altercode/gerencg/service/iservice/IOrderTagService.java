package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderTagDTO;

import java.util.List;

public interface IOrderTagService {
    List<OrderTagDTO> findAllOrderTags();
}
