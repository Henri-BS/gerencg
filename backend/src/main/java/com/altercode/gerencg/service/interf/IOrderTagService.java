package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderTagService {
    Page<OrderTagDTO> findAll(Pageable pageable);

    List<OrderTagDTO> findAllByTag(Tag tag);

    List<OrderTagDTO> findAllByCode(OrderCode orderCode);

    OrderTagDTO findOrderTagById(Long id);

    OrderTagDTO saveTagOrder(OrderTagDTO dto);

    void deleteOrderTag(Long id);
}
