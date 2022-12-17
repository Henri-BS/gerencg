package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.TagDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITagService {
    Page<TagDTO> findAllTags(Pageable pageable, String title);

    List<TagDTO> getAllTags(List<String> title);
}
