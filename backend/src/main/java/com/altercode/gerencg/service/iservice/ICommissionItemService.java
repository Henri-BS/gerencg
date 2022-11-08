package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommissionItemService {
    Page<CommissionItemDTO> findAllCommissions(Pageable pageable);

    List<CommissionItemDTO> findAllCommissionsByCode(CommissionCode code);

    CommissionItemDTO findCommissionById(Long id);

    ProductDTO saveCommission(CommissionItemDTO dto);

    CommissionItemDTO updateCommission(CommissionItemDTO dto);

    void deleteCommission(Long id);

    List<CommissionResultsDTO> commissionResults();


}
