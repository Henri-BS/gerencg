package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.CommissionItem;
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

import java.time.LocalDate;
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


    @Override
    public Page<CommissionItemDTO> findAllItems(Pageable pageable) {
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
    public CommissionItemDTO findItemById(Long id) {
        CommissionItem result = itemRepository.findById(id).get();
        return new CommissionItemDTO(result);
    }

    @Override
    public CommissionItemDTO saveItem(CommissionItemDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        CommissionItem add = new CommissionItem();
        add.setCode(code);
        add.setItemQuantity(dto.getQuantity());
        add.setPackageQuantity(dto.getPackageQuantity());
        add.setUnitValue(dto.getUnitValue());
        add.setTotalValue(dto.getTotalValue());
        add.setItemValidate(dto.getItemValidate());
        add.setProduct(product);

        return new CommissionItemDTO(itemRepository.saveAndFlush(add));
    }

    @Override
    public CommissionItemDTO updateItem(CommissionItemDTO dto) {

        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionItem edit = itemRepository.findById(dto.getId()).get();
        CommissionCode code = commissionCodeRepository.findById(dto.getCommissionCode()).get();

        edit.setId(dto.getId());
        edit.setCode(code);
        edit.setItemQuantity(dto.getQuantity());
        edit.setPackageQuantity(dto.getPackageQuantity());
        edit.setUnitValue(dto.getUnitValue());
        edit.setTotalValue(dto.getTotalValue());
        edit.setItemValidate(dto.getItemValidate());
        edit.setProduct(product);

        return new CommissionItemDTO(edit);
    }

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public List<CommissionResultsDTO> commissionResults() {
        return itemRepository.commissionResults();
    }

    @Override
    public ProductDTO updateProductByItem(CommissionItemDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();
        CommissionItem item = itemRepository.findById(dto.getId()).get();

        int quantity = item.getItemQuantity();
        double price = item.getUnitValue();
        LocalDate date = item.getCode().getCommissionDate();

        product.setQuantity(quantity);
        product.setPrice(price);
        product.setLastUpdateDate(date);
        productRepository.save(product);

        return new ProductDTO(product);
    }


}
