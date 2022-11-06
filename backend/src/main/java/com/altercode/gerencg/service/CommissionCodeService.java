package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Commission;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.ICommissionCodeService;
import com.altercode.gerencg.service.iservice.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommissionCodeService implements ICommissionCodeService {


    @Autowired
    private CommissionCodeRepository commissionCodeRepository;

    @Override
    public Page<CommissionCodeDTO> findAllCommissionCode(Pageable pageable) {
        Page<CommissionCode> result = commissionCodeRepository.findAll(pageable);
        return result.map(x -> new CommissionCodeDTO(x));
    }

    @Override
    public CommissionCodeDTO findCodeById(String id) {
        CommissionCode result = commissionCodeRepository.findById(id).get();
        return new CommissionCodeDTO(result);
    }


}
