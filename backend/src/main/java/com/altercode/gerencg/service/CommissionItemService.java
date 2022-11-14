package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionDataDTO;
import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionData;
import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CommissionCodeRepository;
import com.altercode.gerencg.repository.CommissionDataRepository;
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
    private CommissionItemRepository itemRepository;

    @Autowired
    private CommissionCodeRepository commissionCodeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommissionDataRepository dataRepository;


    @Override
    public Page<CommissionItemDTO> findAllCommissions(Pageable pageable) {
        Page<CommissionItem> result = itemRepository.findAll(pageable);
        return result.map(x -> new CommissionItemDTO(x));
    }

    public List<CommissionItemDTO> findItemsByCode(CommissionCode code) {
        List<CommissionItem> result = itemRepository.findAllCommissionsByCode(code);
        return result.stream().map(x -> new CommissionItemDTO(x)).collect(Collectors.toList());
    }

    @Override
    public List<CommissionItemDTO> findItemByProduct(Product product) {
        List<CommissionItem> result = itemRepository.findItemByProduct(product);
        return result.stream().map(x -> new CommissionItemDTO(x)).collect(Collectors.toList());
    }

    @Override
    public CommissionItemDTO findCommissionById(Long id) {
        CommissionItem result = itemRepository.findById(id).get();
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
        itemRepository.saveAndFlush(add);

        int sum = add.getQuantity();
        sum = sum + product.getQuantity();
        product.setQuantity(sum);
        productRepository.save(product);

        return new ProductDTO(product);
    }

    @Override
    public CommissionItemDTO updateCommission(CommissionItemDTO dto) {

        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionItem edit = itemRepository.findById(dto.getId()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        edit.setId(dto.getId());
        edit.setCode(code);
        edit.setQuantity(dto.getQuantity());
        edit.setTotalValue(dto.getTotalValue());
        edit.setProduct(product);
        edit = itemRepository.save(edit);

        return new CommissionItemDTO(edit);
    }

    @Override
    public void deleteCommission(Long id) {
        this.itemRepository.findById(id);
    }

    @Override
    public List<CommissionResultsDTO> commissionResults() {
        return itemRepository.orderResults();
    }

    @Override
    public ProductDTO updateProductByItem(CommissionDataDTO dto) {
        Product product = productRepository.findById(dto.getProductId()).get();
        CommissionItem item = itemRepository.findById(dto.getItemId()).get();

        CommissionData data = new CommissionData();
        data.setCommission(item);
        data.setProduct(product);
dataRepository.saveAndFlush(data);

        int sum = item.getQuantity();
        sum = sum + product.getQuantity();
        product.setQuantity(sum);
        productRepository.save(product);

        return new ProductDTO(product);
    }
}
