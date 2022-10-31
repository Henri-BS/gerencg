package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.OrderRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<OrderDTO> findAllOrders(Pageable pageable) {
        Page<Order> result = orderRepository.findAll(pageable);
        return result.map(x -> new OrderDTO(x));
    }

    @Override
    public OrderDTO findOrderById(String id) {
        Order result = orderRepository.findById(id).get();
        return new OrderDTO(result);
    }

    @Override
    public OrderDTO addOrder(OrderDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();

        Order add = new Order();

        add.setId(dto.getId());
        add.setOrderDate(dto.getOrderDate());
        add.setTotalValue(dto.getTotalValue());
        add.setQuantity(dto.getQuantity());
        add.setDistributor(dto.getDistributor());
        add.setProduct(product);

        return new OrderDTO(orderRepository.saveAndFlush(add));
    }

    @Override
    public OrderDTO updateOrder(OrderDTO dto) {

        Product product = productRepository.findById(dto.getProduct()).get();
        Order edit = orderRepository.findById(dto.getId()).get();

        edit.setId(dto.getId());
        edit.setOrderDate(dto.getOrderDate());
        edit.setQuantity(dto.getQuantity());
        edit.setTotalValue(dto.getTotalValue());
        edit.setDistributor(dto.getDistributor());
        edit.setProduct(product);
        edit = orderRepository.save(edit);

        return new OrderDTO(edit);
    }

    @Override
    public void deleteOrder(String id) {
this.orderRepository.findById(id);
    }
}
