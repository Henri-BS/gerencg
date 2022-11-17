package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICommissionCodeService {
    Page<CommissionCodeDTO> findAllCommissionsByCode(Pageable pageable, String code);

    CommissionCodeDTO findCodeById(String id);

    CommissionCodeDTO sumItemValues(CommissionCodeDTO dto);

    CommissionCodeDTO saveCommissionCode(CommissionCodeDTO code);

}