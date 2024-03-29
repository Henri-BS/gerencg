package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.OrderRepository;
import com.altercode.gerencg.repository.OrderTagRepository;
import com.altercode.gerencg.repository.TagRepository;
import com.altercode.gerencg.service.interf.IOrderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderTagService implements IOrderTagService {

    @Autowired
    private OrderTagRepository orderTagRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<OrderTagDTO> findAll(Pageable pageable){
        Page<OrderTag> list = orderTagRepository.findAll(pageable);
        return list.map(OrderTagDTO::new);
    }

    @Override
    public List<OrderTagDTO> findAllByTag(Tag tag){
        List<OrderTag> list = orderTagRepository.findAllByTag(tag);
        return list.stream().map(OrderTagDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderTagDTO> findAllByCode(Order order) {
        List<OrderTag> list = orderTagRepository.findAllByCode(order);
        return list.stream().map(OrderTagDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderTagDTO findOrderTagById(Long id) {
        OrderTag find = orderTagRepository.findById(id).get();
        return new OrderTagDTO(find);
    }

    @Override
    public OrderTagDTO saveOrderTag(OrderTagDTO dto) {
        Order code = orderRepository.findById(dto.getCodeId()).orElseThrow();
        Tag tag = tagRepository.findById(dto.getTagId()).orElseThrow();

        OrderTag add = new OrderTag();
        add.setCode(code);
        if(tagRepository.existsById(tag.getTagId())){
            add.setTag(tag);
        } else {
            tag = new Tag();
            tag.setTagId(add.getTag().getTagId());
            tagRepository.saveAndFlush(tag);
            add.setTag(tag);
        }
        return new OrderTagDTO(orderTagRepository.saveAndFlush(add));
    }

    @Override
    public void deleteOrderTag(Long id) {
        this.orderTagRepository.deleteById(id);
    }
}
