package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Commission;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommissionService implements ICommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    @Autowired
    private CommissionCodeRepository commissionCodeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<CommissionDTO> findAllCommissions(Pageable pageable) {
        Page<Commission> result = commissionRepository.findAll(pageable);
        return result.map(x -> new CommissionDTO(x));
    }

    @Override
    public CommissionDTO findCommissionById(Long id) {
        Commission result = commissionRepository.findById(id).get();
        return new CommissionDTO(result);
    }

    @Override
    public ProductDTO saveCommission(CommissionDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionCode code = commissionCodeRepository.findByCode(dto.getCommissionCode());

        if (code == null) {
            code = new CommissionCode();
            code.setCode(dto.getCommissionCode());
            code = commissionCodeRepository.saveAndFlush(code);
        }

        Commission add = new Commission();
        add.setCode(code);
        add.setOrderDate(dto.getOrderDate());
        add.setTotalValue(dto.getTotalValue());
        add.setQuantity(dto.getQuantity());
        add.setDistributor(dto.getDistributor());
        add.setProduct(product);

        commissionRepository.saveAndFlush(add);

        int sum = add.getQuantity();
        sum = sum + product.getQuantity();

        product.setQuantity(sum);
        productRepository.save(product);

        return new ProductDTO(product);
    }

    @Override
    public CommissionDTO updateCommission(CommissionDTO dto) {

        Product product = productRepository.findById(dto.getProduct()).get();
        Commission edit = commissionRepository.findById(dto.getId()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        edit.setId(dto.getId());
        edit.setCode(code);
        edit.setOrderDate(dto.getOrderDate());
        edit.setQuantity(dto.getQuantity());
        edit.setTotalValue(dto.getTotalValue());
        edit.setDistributor(dto.getDistributor());
        edit.setProduct(product);
        edit = commissionRepository.save(edit);

        return new CommissionDTO(edit);
    }

    @Override
    public void deleteCommission(Long id) {
        this.commissionRepository.findById(id);
    }

    @Override
    public List<CommissionResultsDTO> commissionResults() {
        return commissionRepository.orderResults();
    }

}
