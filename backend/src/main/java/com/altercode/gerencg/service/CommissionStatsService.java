package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionStatsDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.CommissionStats;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionStatsRepository;
import com.altercode.gerencg.service.iservice.ICommissionStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CommissionStatsService implements ICommissionStatsService {

    @Autowired
    CommissionStatsRepository statsRepository;

    @Autowired
    CommissionCodeRepository codeRepository;

    @Override
    public List<CommissionStatsDTO> findAllStats(String id) {
        List<CommissionStats> result = statsRepository.findAllStats(id);
        return result.stream().map(x -> new CommissionStatsDTO(x)).collect(Collectors.toList());
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
