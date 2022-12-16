package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.TagRepository;
import com.altercode.gerencg.service.iservice.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagService implements ITagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<TagDTO> findTagsByTitle(Pageable pageable, String title) {
        Page<Tag> list = tagRepository.findTagsByTitle(pageable, title);
        return list.map(x -> new TagDTO(x));
    }
}
