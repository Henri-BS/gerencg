package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionStatsDTO;

import java.util.List;

public interface ICommissionStatsService {

    List<CommissionStatsDTO> findAllStats(String id);

     CommissionStatsDTO saveCommissionStats(CommissionStatsDTO dto);

}
