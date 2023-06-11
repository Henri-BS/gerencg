package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.OrderTagRepository;
import com.altercode.gerencg.repository.TagRepository;
import com.altercode.gerencg.service.interf.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TagService implements ITagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private OrderTagRepository orderTagRepository;

    @Override
    public Page<TagDTO> findAllTags(Pageable pageable) {
        Page<Tag> list = tagRepository.findAll(pageable);
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

    public TagDTO saveTag(TagDTO dto) {
        Tag add = new Tag();
        add.setDescription(dto.getDescription());
        return new TagDTO(tagRepository.saveAndFlush(add));
    }
}
