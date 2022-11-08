package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICommissionCodeService {
    Page<CommissionCodeDTO> findAllCommissionsByCode(Pageable pageable, String code);

    CommissionCodeDTO findCodeById(String id);

    CommissionCodeDTO saveCommissionCode(CommissionCodeDTO code);

}