package com.altercode.gerencg.service;

import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.repository.*;
import com.altercode.gerencg.service.iservice.IProductHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.ProductHistory;

@Service
@Transactional
public class ProductHistoryService implements IProductHistoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductHistoryRepository historyRepository;

    @Autowired
    private OrderItemRepository itemRepository;

    @Override
    public Page<ProductHistoryDTO> findAll(Pageable pageable) {
        Page<ProductHistory> result = historyRepository.findAll(pageable);
        return result.map(x -> new ProductHistoryDTO(x));
    }

    @Override
    public Page<ProductHistoryDTO> findByProduct(Pageable pageable, Product product) {
        Page<ProductHistory> result = historyRepository.findByProduct(pageable, product);
        return result.map(x -> new ProductHistoryDTO(x));
    }

    @Override
    public ProductHistoryDTO findHistoryById(Long id) {
        ProductHistory findHistory = historyRepository.findById(id).get();
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
        history.setCreatedDate(history.getCreatedDate());
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

        edit.setPrice(dto.getPrice());
        edit.setQuantity(dto.getQuantity());
        edit.setValidate(dto.getValidate());
        edit.setCreatedDate(dto.getCreatedDate());
        historyRepository.save(edit);

        return new ProductHistoryDTO(edit);
    }

    @Override
    public ProductHistoryDTO updateProductHistoryValue(ProductHistoryDTO dto) {
        ProductHistory history = historyRepository.findById(dto.getId()).get();

        double income;
        income = history.getQuantity() * history.getPrice();
        history.setIncome(income);
        historyRepository.save(history);
        return new ProductHistoryDTO(history);
    }

    @Override
    public void deleteProductHistory(Long id) {
        this.historyRepository.deleteById(id);
    }



}
