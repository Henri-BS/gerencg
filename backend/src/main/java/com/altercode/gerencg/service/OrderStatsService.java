package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderStatsDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.repository.OrderCodeRepository;
import com.altercode.gerencg.repository.OrderStatsRepository;
import com.altercode.gerencg.service.iservice.IOrderStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class OrderStatsService implements IOrderStatsService {

    @Autowired
    OrderStatsRepository statsRepository;

    @Autowired
    OrderCodeRepository codeRepository;

    @Override
    public List<OrderStatsDTO> findAllStats(String id) {
        List<OrderStats> result = statsRepository.findAllStats(id);
        return result.stream().map(x -> new OrderStatsDTO(x)).collect(Collectors.toList());
    }

    @Override
    public OrderStatsDTO saveCommissionStats(OrderStatsDTO dto) {
        OrderStats add = new OrderStats();
        add.setId(dto.getId());
        add.setInitialDate(dto.getInitialDate());
        add.setFinalDate(dto.getFinalDate());

        return new OrderStatsDTO(statsRepository.saveAndFlush(add));
    }

    @Override
    public OrderStatsDTO updateStatsValues(OrderStatsDTO dto) {
        OrderStats stats = statsRepository.findById(dto.getId()).get();

        double sumValues = 0;
        int sumItems = 0;
        for (OrderCode i : stats.getCodes()) {
            sumValues = sumValues + i.getTotalValue();
            sumItems = sumItems + i.getAmountItems();
        }

        double avgWeeks;
        avgWeeks = sumValues / 4;

        stats.setTotalValue(sumValues);
        stats.setAverageWeek(avgWeeks);
        stats.setAmountCommission(stats.getCodes().size());
        stats.setAmountItems(sumItems);
        statsRepository.save(stats);

        return new OrderStatsDTO(stats);
    }


}
