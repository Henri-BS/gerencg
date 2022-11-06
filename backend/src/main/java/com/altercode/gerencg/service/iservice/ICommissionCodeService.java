package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommissionCodeService {
    Page<CommissionCodeDTO> findAllCommissionCode(Pageable pageable);

    CommissionCodeDTO findCodeById(String id);

}
