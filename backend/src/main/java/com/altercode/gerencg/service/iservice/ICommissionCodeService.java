package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICommissionCodeService {
    Page<CommissionCodeDTO> findAllCommissionCode(Pageable pageable);

    CommissionCodeDTO findCodeById(String id);

    CommissionCodeDTO saveCommissionCode(CommissionCodeDTO code);

}