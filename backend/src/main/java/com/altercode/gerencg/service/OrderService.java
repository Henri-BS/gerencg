package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderDTO;
import com.altercode.gerencg.dto.SumCategoryQuantityDTO;
import com.altercode.gerencg.dto.SumCategoryValueDTO;
import com.altercode.gerencg.entity.*;
import com.altercode.gerencg.repository.*;
import com.altercode.gerencg.service.interf.IOrderCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderCodeService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStatsRepository statsRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<OrderDTO> findByCode(Pageable pageable, String code) {
        Page<Order> result = orderRepository.findByCodeLikeIgnoreCase(code, pageable);
        return result.map(OrderDTO::new);
    }

    @Override
    public OrderDTO findCodeById(String id) {
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
    public Page<OrderDTO> findOrdersByStats(Pageable pageable, OrderStats stats) {
        Page<Order> result = orderRepository.findOrdersByStats(pageable, stats);
        return result.map(OrderDTO::new);
    }

    @Override
    public OrderDTO saveOrder(OrderDTO dto) {
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow();

        Order add = new Order();
        add.setCode(dto.getCode());
        add.setOrderDate(dto.getOrderDate());
        add.setDistributor(dto.getDistributor());
        add.setPackageType(packageType);
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
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();

        edit.setCode(edit.getCode());
        edit.setOrderDate(dto.getOrderDate());
        edit.setDistributor(dto.getDistributor());
        edit.setPackageType(packageType);
        return new OrderDTO(orderRepository.save(edit));
    }

    @Override
    public void deleteOrder(String id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public OrderDTO orderTotalValues(OrderDTO dto) {
        Order code = orderRepository.findById(dto.getCode()).get();
        double sumValues = 0;
        int sumQuantity = 0;
        int sumPackages = 0;
        for (OrderItem i : code.getItems()) {
            sumValues = sumValues + i.getTotalValue();
            sumQuantity = sumQuantity + i.getItemQuantity();
            sumPackages = sumPackages + i.getPackageQuantity();
        }

        double sumValuesRound = Math.round(sumValues * 100) / 100.00;
        code.setTotalValue(sumValuesRound);
        code.setTotalQuantity(sumQuantity);
        code.setTotalPackage(sumPackages);
        code.setAmountItems(code.getItems().size());
        orderRepository.save(code);

        return new OrderDTO(code);
    }

    @Override
    public List<SumCategoryValueDTO> getOrderValueGroupByCategory() {
        return orderRepository.getOrderValueGroupByCategory();
    }

    @Override
    public List<SumCategoryQuantityDTO> getOrderQuantityGroupByCategory() {
        return orderRepository.getOrderQuantityGroupByCategory();
    }
}