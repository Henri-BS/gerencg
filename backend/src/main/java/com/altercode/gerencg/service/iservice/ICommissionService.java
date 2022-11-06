package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommissionService {
    Page<CommissionDTO> findAllCommissions(Pageable pageable);

    List<CommissionDTO> findAllCommissionsByCode( CommissionCode code);

    CommissionDTO findCommissionById(Long id);

    ProductDTO saveCommission(CommissionDTO dto);

    CommissionDTO updateCommission(CommissionDTO dto);

    void deleteCommission(Long id);

    List<CommissionResultsDTO> commissionResults();


}
