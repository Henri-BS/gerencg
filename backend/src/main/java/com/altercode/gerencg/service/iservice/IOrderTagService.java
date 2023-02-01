package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Tag;

import java.util.List;

public interface IOrderTagService {
    List<OrderTagDTO> findAllOrderTags();

    List<OrderTagDTO> findAllOrdersByTag(Tag tag);
}
