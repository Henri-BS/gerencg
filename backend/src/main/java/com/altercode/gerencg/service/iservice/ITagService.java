package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.TagDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITagService {
    Page<TagDTO> findTagsByTitle(Pageable pageable, String title);
}
