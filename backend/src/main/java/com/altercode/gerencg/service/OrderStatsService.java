package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.dto.OrderStatsTotalValueDTO;
import com.altercode.gerencg.dto.SumQuantityOrderDTO;
import com.altercode.gerencg.dto.SumValueOrderDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.repository.OrderStatsRepository;
import com.altercode.gerencg.service.interf.IOrderStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class OrderStatsService implements IOrderStatsService {

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
    public OrderStatsDTO updateStatsValues(OrderStatsDTO dto) {
        OrderStats stats = statsRepository.findById(dto.getId()).get();

            for (Order i : stats.getCodes()) {
                double sumValues = stats.getTotalValue();
                int sumItems = stats.getAmountItems();
                sumValues = sumValues + i.getTotalValue();
                sumItems = sumItems + i.getAmountItems();

                double avgWeeks;
                avgWeeks = sumValues / 4;
                stats.setAverageWeek(avgWeeks);
                stats.setAmountItems(sumItems);
                stats.setTotalValue(sumValues);
            }

        stats.setAmountOrder(stats.getCodes().size());

        return new OrderStatsDTO(statsRepository.save(stats));
    }



    @Override
    public OrderStatsTotalValueDTO getOrderStatsTotalValues(){
        return statsRepository.getOrderStatsTotalValue();
    }

    @Override
    public List<SumQuantityOrderDTO> getOrderStatsQuantityGroup() {
        return statsRepository.getSumOrderStatsGroup();
    }

    @Override
    public List<SumValueOrderDTO> getOrderStatsValueGroup() {
        return statsRepository.getSumValuesStats();
    }
}
