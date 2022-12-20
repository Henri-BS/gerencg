package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionStatsDTO;
import com.altercode.gerencg.entity.CommissionStats;
import com.altercode.gerencg.repository.CommissionStatsRepository;
import com.altercode.gerencg.service.iservice.ICommissionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommissionStatsService implements ICommissionStatsService {

    @Autowired
    CommissionStatsRepository statsRepository;


    @Override
    public List<CommissionStatsDTO> findAllStats(String id) {
        return null;
    }

    @Override
    public CommissionStatsDTO saveCommissionStats(CommissionStatsDTO dto) {
        CommissionStats add = new CommissionStats();
        add.setId(dto.getId());
        add.setInitialDate(dto.getInitialDate());
        add.setFinalDate(dto.getFinalDate());

        return new CommissionStatsDTO(statsRepository.saveAndFlush(add));
    }
}
