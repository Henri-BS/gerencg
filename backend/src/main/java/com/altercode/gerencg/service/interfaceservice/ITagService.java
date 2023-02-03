package com.altercode.gerencg.service.interfaceservice;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.dto.TagDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITagService {
    Page<TagDTO> findAllTags(Pageable pageable, String title);

    List<TagDTO> getAllTags(List<String> title);
    List<OrderTagDTO> findAllOrdersByTag();
}
