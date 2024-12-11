package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.OrderTagRepository;
import com.altercode.gerencg.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TagServiceImpl implements com.altercode.gerencg.service.interf.TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private OrderTagRepository orderTagRepository;

    @Override
    public Page<TagDTO> findAllTags(String tagId, Pageable pageable) {
        Page<Tag> list = tagRepository.findAllTags(tagId, pageable);
        return list.map(TagDTO::new);
    }

    @Override
    public List<TagDTO> getAllTags(List<String> title) {
        List<Tag> result = tagRepository.findAllById(title);
        return result.stream().map(TagDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderTagDTO> findAllOrdersByTag() {
        List<OrderTag> list = orderTagRepository.findAll();
        return list.stream().map(OrderTagDTO::new).collect(Collectors.toList());
    }

    @Override
    public TagDTO saveTag(TagDTO dto) {
        Tag add = new Tag();
        add.setTagId(dto.getTagId());
        add.setDescription(dto.getDescription());
        return new TagDTO(tagRepository.saveAndFlush(add));
    }
}
