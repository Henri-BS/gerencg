package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsTotalValueDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.repository.OrderStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrderStatsServiceImpl implements com.altercode.gerencg.service.interf.OrderStatsService {

    @Autowired
    OrderStatsRepository statsRepository;

    @Override
    public Page<OrderStatsDTO> findAllStats(Pageable pageable) {
        Page<OrderStats> result = statsRepository.findAll(pageable);
        return result.map(OrderStatsDTO::new);
    }

    @Override
    public OrderStatsDTO findOrderStatsById(String id) {
        OrderStats stats = statsRepository.findById(id).get();
        return new OrderStatsDTO(stats);
    }

    @Override
    public OrderStatsDTO saveOrderStats(OrderStatsDTO dto) {
        OrderStats add = new OrderStats();
        add.setId(dto.getId());
        add.setInitialDate(dto.getInitialDate());
        add.setFinalDate(dto.getFinalDate());

        return new OrderStatsDTO(statsRepository.saveAndFlush(add));
    }

    @Override
    public OrderStatsDTO updateOrderStats(OrderStatsDTO dto) {
        OrderStats edit = statsRepository.findById(dto.getId()).orElseThrow();

        edit.setInitialDate(dto.getInitialDate());
        edit.setFinalDate(dto.getFinalDate());

        return new OrderStatsDTO(statsRepository.save(edit));
    }

    @Override
    public OrderStatsDTO updateStatsValues(OrderStatsDTO dto) {
        OrderStats stats = statsRepository.findById(dto.getId()).get();
        double sumExpense = 0;
        double sumIncome = 0;

        int sumItems = stats.getAmountItems();
        for (Order order : stats.getOrders()) {
            sumExpense = sumExpense + order.getExpense();
            sumIncome = sumIncome + order.getIncome();
            sumItems = sumItems + order.getAmountItems();
        }

        double expenseAverageWeek, incomeAverageWeek;
        expenseAverageWeek = sumExpense / 4;
        incomeAverageWeek = sumIncome / 4;
        stats.setExpenseAverageWeek(expenseAverageWeek);
        stats.setIncomeAverageWeek(incomeAverageWeek);
        stats.setExpense(sumExpense);
        stats.setIncome(sumIncome);
        stats.setAmountItems(sumItems);
        stats.setAmountOrder(stats.getOrders().size());

        return new OrderStatsDTO(statsRepository.save(stats));
    }

    @Override
    public OrderStatsTotalValueDTO getOrderStatsTotalValues() {
        return statsRepository.getOrderStatsTotalValue();
    }

    @Override
    public List<OrderStatsTotalValueDTO> getOrderStatsQuantityGroup() {
        return statsRepository.sumQuantitiesGroupById();
    }

    @Override
    public List<OrderStatsTotalValueDTO> getOrderStatsValueGroup() {
        return statsRepository.sumValuesGroupById();
    }

    @Override
    public void deleteOrderStats(String id) {
        this.statsRepository.deleteById(id);
    }
}
