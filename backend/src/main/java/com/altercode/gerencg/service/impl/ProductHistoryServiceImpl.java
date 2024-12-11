package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.ProductHistory;

import java.time.LocalDate;

@Service
@Transactional
public class ProductHistoryServiceImpl implements com.altercode.gerencg.service.interf.ProductHistoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductHistoryRepository historyRepository;

    @Autowired
    private OrderItemRepository itemRepository;

    @Override
    public Page<ProductHistoryDTO> findAll(Pageable pageable) {
        Page<ProductHistory> result = historyRepository.findAll(pageable);
        return result.map(ProductHistoryDTO::new);
    }

    @Override
    public Page<ProductHistoryDTO> findByProduct(Pageable pageable, Product product) {
        Page<ProductHistory> result = historyRepository.findByProduct(pageable, product);
        return result.map(ProductHistoryDTO::new);
    }

    @Override
    public ProductHistoryDTO findHistoryById(Long id) {
        ProductHistory findHistory = historyRepository.findById(id).get();
        double income;
        income = findHistory.getPrice() * findHistory.getQuantity();
        findHistory.setIncome(income);
        historyRepository.save(findHistory);
        return new ProductHistoryDTO(findHistory);
    }

    @Override
    public ProductHistoryDTO saveHistory(ProductHistoryDTO dto) {
        Product product = productRepository.findById(dto.getProductId()).get();

        ProductHistory history = new ProductHistory();
        history.setProduct(product);
        history.setPrice(product.getPrice());
        history.setQuantity(product.getQuantity());
        history.setValidate(product.getValidate());
        history.setDateCreated(LocalDate.now());
        historyRepository.saveAndFlush(history);

        return new ProductHistoryDTO(history);
    }

    @Override
    public ProductHistoryDTO saveItemHistory(Long id) {
        OrderItem item = itemRepository.findById(id).get();

        ProductHistory history = new ProductHistory();
        history.setProduct(item.getProduct());
        history.setPrice(item.getUnitValue());
        history.setQuantity(item.getItemQuantity());
        history.setValidate(item.getItemValidate());
        historyRepository.saveAndFlush(history);

        return new ProductHistoryDTO(history);
    }

    @Override
    public ProductHistoryDTO updateHistory(ProductHistoryDTO dto) {
        ProductHistory edit = historyRepository.findById(dto.getId()).get();

        edit.setId(edit.getId());
        edit.setPrice(dto.getPrice());
        edit.setQuantity(dto.getQuantity());
        edit.setValidate(dto.getValidate());
        edit.setDateCreated(dto.getDateCreated());

        return new ProductHistoryDTO(historyRepository.save(edit));
    }

    @Override
    public ProductHistoryDTO updateProductHistoryValue(ProductHistoryDTO dto) {
        ProductHistory history = historyRepository.findById(dto.getId()).get();
        return new ProductHistoryDTO(history);
    }

    @Override
    public void deleteProductHistory(Long id) {
        this.historyRepository.deleteById(id);
    }

}
