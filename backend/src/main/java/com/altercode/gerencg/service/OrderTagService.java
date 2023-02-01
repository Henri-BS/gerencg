package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderTagDTO;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import com.altercode.gerencg.repository.OrderTagRepository;
import com.altercode.gerencg.service.iservice.IOrderTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderTagService implements IOrderTagService {

    @Autowired
    private OrderTagRepository orderTagRepository;

    @Override
    public List<OrderTagDTO> findAllOrderTags(){
        List<OrderTag> list = orderTagRepository.findAll();
        return list.stream().map(x -> new OrderTagDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<OrderTagDTO> findAllOrdersByTag(Tag tag){
        List<OrderTag> list = orderTagRepository.findAllOrdersByTag(tag);
        return list.stream().map(x -> new OrderTagDTO(x)).collect(Collectors.toList());
    }
}
