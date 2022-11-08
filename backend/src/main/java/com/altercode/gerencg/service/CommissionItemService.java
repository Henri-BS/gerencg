package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionItemRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.ICommissionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommissionItemService implements ICommissionItemService {

    @Autowired
    private CommissionItemRepository commissionItemRepository;

    @Autowired
    private CommissionCodeRepository commissionCodeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<CommissionItemDTO> findAllCommissions(Pageable pageable) {
        Page<CommissionItem> result = commissionItemRepository.findAll(pageable);
        return result.map(x -> new CommissionItemDTO(x));
    }

    public List<CommissionItemDTO> findAllCommissionsByCode(CommissionCode code) {
        List<CommissionItem> result = commissionItemRepository.findAllCommissionsByCode(code);
        return result.stream().map(x -> new CommissionItemDTO(x)).collect(Collectors.toList());
    }

    @Override
    public CommissionItemDTO findCommissionById(Long id) {
        CommissionItem result = commissionItemRepository.findById(id).get();
        return new CommissionItemDTO(result);
    }

    @Override
    public ProductDTO saveCommission(CommissionItemDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        CommissionItem add = new CommissionItem();
        add.setCode(code);
        add.setTotalValue(dto.getTotalValue());
        add.setQuantity(dto.getQuantity());
        add.setProduct(product);
        commissionItemRepository.saveAndFlush(add);

        int sum = add.getQuantity();
        sum = sum + product.getQuantity();
        product.setQuantity(sum);
        productRepository.save(product);

        return new ProductDTO(product);
    }

    @Override
    public CommissionItemDTO updateCommission(CommissionItemDTO dto) {

        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionItem edit = commissionItemRepository.findById(dto.getId()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        edit.setId(dto.getId());
        edit.setCode(code);
        edit.setQuantity(dto.getQuantity());
        edit.setTotalValue(dto.getTotalValue());
        edit.setProduct(product);
        edit = commissionItemRepository.save(edit);

        return new CommissionItemDTO(edit);
    }

    @Override
    public void deleteCommission(Long id) {
        this.commissionItemRepository.findById(id);
    }

    @Override
    public List<CommissionResultsDTO> commissionResults() {
        return commissionItemRepository.orderResults();
    }

}
