package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.service.iservice.ICommissionCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public CommissionCodeDTO saveCommissionCode(CommissionCodeDTO dto) {

        CommissionCode add = new CommissionCode();
        add.setCode(dto.getCode());
        add.setCommissionDate(dto.getCommissionDate());
        add.setDistributor(dto.getDistributor());

        return new CommissionCodeDTO(commissionCodeRepository.saveAndFlush(add));
    }


}
