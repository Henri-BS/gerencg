package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionCodeDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionItemRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import com.altercode.gerencg.repository.TagRepository;
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
    private CommissionCodeRepository codeRepository;

    @Autowired
    private CommissionItemRepository itemRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<CommissionCodeDTO> findItemsByCode(Pageable pageable, String code) {
        Page<CommissionCode> result = codeRepository.findCommissionsByCode(pageable, code);
        return result.map(x -> new CommissionCodeDTO(x));
    }

    @Override
    public CommissionCodeDTO findCodeById(String id) {
        CommissionCode result = codeRepository.findById(id).get();
        return new CommissionCodeDTO(result);
    }

    @Override
    public CommissionCodeDTO saveCommission(CommissionCodeDTO dto) {
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();

        CommissionCode add = new CommissionCode();
        add.setCode(dto.getCode());
        add.setCommissionDate(dto.getCommissionDate());
        add.setDistributor(dto.getDistributor());
        add.setPackageType(packageType);

        return new CommissionCodeDTO(codeRepository.saveAndFlush(add));
    }

    @Override
    public CommissionCodeDTO updateCommission(CommissionCodeDTO dto) {
        CommissionCode edit = codeRepository.findById(dto.getCode()).get();
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();

        edit.setCode(edit.getCode());
        edit.setCommissionDate(dto.getCommissionDate());
        edit.setDistributor(dto.getDistributor());
        edit.setPackageType(packageType);
        return new CommissionCodeDTO(codeRepository.save(edit));
    }

    @Override
    public void deleteCommission(String id) {
        this.codeRepository.deleteById(id);
    }

    @Override
    public CommissionCodeDTO commissionTotalValues(CommissionCodeDTO dto) {
        CommissionCode code = codeRepository.findById(dto.getCode()).get();

        double sumValues = 0;
        int sumQuantity = 0;
        int sumPackages = 0;
        for (CommissionItem i : code.getCommissions()) {
            sumValues = sumValues + i.getTotalValue();
            sumQuantity = sumQuantity + i.getItemQuantity();
            sumPackages = sumPackages + i.getPackageQuantity();
        }

        code.setTotalValue(sumValues);
        code.setTotalQuantity(sumQuantity);
        code.setTotalPackage(sumPackages);
        code.setAmountItems(code.getCommissions().size());
        codeRepository.save(code);

        return new CommissionCodeDTO(code);
    }
}
