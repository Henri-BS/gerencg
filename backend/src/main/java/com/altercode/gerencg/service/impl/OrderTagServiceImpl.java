package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.OrderRepository;
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
public class OrderTagServiceImpl implements com.altercode.gerencg.service.interf.OrderTagService {

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
    public List<OrderTagDTO> findByTag(Tag tag){
        List<OrderTag> list = orderTagRepository.findByTag(tag);
        return list.stream().map(OrderTagDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderTagDTO> findByOrder(Order order) {
        List<OrderTag> list = orderTagRepository.findByOrder(order);
        return list.stream().map(OrderTagDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderTagDTO findOrderTagById(Long id) {
        OrderTag find = orderTagRepository.findById(id).get();
        return new OrderTagDTO(find);
    }

    @Override
    public OrderTagDTO saveOrderTag(OrderTagDTO dto) {
        Order code = orderRepository.findById(dto.getOrderId()).orElseThrow();
        Tag tag = tagRepository.findById(dto.getTagId()).orElseThrow();

        OrderTag add = new OrderTag();
        add.setOrder(code);
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
