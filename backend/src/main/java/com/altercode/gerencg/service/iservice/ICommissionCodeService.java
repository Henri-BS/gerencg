package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionStatsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommissionCodeService {
    Page<CommissionCodeDTO> findItemsByCode(Pageable pageable, String code);

    CommissionCodeDTO findCodeById(String id);

    CommissionCodeDTO saveCommission(CommissionCodeDTO dto);

    CommissionCodeDTO updateCommission(CommissionCodeDTO dto);

    void deleteCommission(String id);

    CommissionCodeDTO commissionTotalValues(CommissionCodeDTO dto);

    List<CommissionCodeDTO> findCommissionsByStats(String stats);
}