package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.entity.*;
import com.altercode.gerencg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements com.altercode.gerencg.service.interf.OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatsRepository statsRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<OrderDTO> findOrders(Pageable pageable, String code) {
        Page<Order> result = orderRepository.findOrders(code, pageable);
        return result.map(OrderDTO::new);
    }

    @Override
    public Page<OrderDTO> findOrdersByStats(Pageable pageable, OrderStats stats) {
        Page<Order> result = orderRepository.findOrdersByStats(pageable, stats);
        return result.map(OrderDTO::new);
    }

    @Override
    public OrderDTO findOrderById(String id) {
        Order result = orderRepository.findById(id).get();
        if (result.getStats() == null) {
            String statsId = result.getOrderDate().getMonthValue() + "-" + result.getOrderDate().getYear();
            OrderStats stats = statsRepository.findById(statsId).orElseThrow();
            result.setStats(stats);
            orderRepository.save(result);
        }
        return new OrderDTO(result);
    }

    @Override
    public OrderDTO saveOrder(OrderDTO dto) {
        Measure packageType = measureRepository.findById(dto.getMeasure()).get();
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow();

        Order add = new Order();
        add.setCode(dto.getCode());
        add.setOrderDate(dto.getOrderDate());
        add.setDistributor(dto.getDistributor());
        add.setMeasure(packageType);
        add.setCategory(category);

        String statsId = "0" + add.getOrderDate().getMonthValue() + "-" + add.getOrderDate().getYear();

        if(statsRepository.existsById(statsId)) {
           OrderStats stats = statsRepository.findById(statsId).orElseThrow();
            add.setStats(stats);
        } else {
            OrderStats stats = new OrderStats();
            stats.setId(statsId);
            statsRepository.saveAndFlush(stats);
            add.setStats(stats);
        }

        return new OrderDTO(orderRepository.saveAndFlush(add));
    }

    @Override
    public OrderDTO updateOrder(OrderDTO dto) {
        Order edit = orderRepository.findById(dto.getCode()).get();
        Measure packageType = measureRepository.findById(dto.getMeasure()).get();

        edit.setCode(edit.getCode());
        edit.setOrderDate(dto.getOrderDate());
        edit.setDistributor(dto.getDistributor());
        edit.setMeasure(packageType);
        return new OrderDTO(orderRepository.save(edit));
    }

    @Override
    public void deleteOrder(String id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public OrderDTO orderTotalValues(OrderDTO dto) {
        Order order = orderRepository.findById(dto.getCode()).get();
        double sumValues = 0, sumIncome = 0;
        int sumQuantity = 0, sumPackages = 0;
        for (OrderItem item : order.getItems()) {
            sumValues = sumValues + item.getExpense();
            sumIncome = sumIncome + item.getIncome();
            sumQuantity = sumQuantity + item.getItemQuantity();
            sumPackages = sumPackages + item.getPackageQuantity();
        }

        order.setExpense(sumValues);
        order.setIncome(sumIncome);
        order.setTotalQuantity(sumQuantity);
        order.setTotalPackage(sumPackages);
        order.setAmountItems(order.getItems().size());
        orderRepository.save(order);

        return new OrderDTO(order);
    }

    @Override
    public List<CategoryStatsTotalValueDTO> getOrderValueGroupByCategory() {
        return orderRepository.getOrderValueGroupByCategory();
    }

    @Override
    public List<CategoryStatsTotalValueDTO> getOrderQuantityGroupByCategory() {
        return orderRepository.getOrderQuantityGroupByCategory();
    }
}