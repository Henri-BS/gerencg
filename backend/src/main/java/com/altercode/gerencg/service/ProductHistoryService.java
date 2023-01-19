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

import java.time.LocalDate;
import java.util.List;

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
    public ProductHistoryDTO saveItemInHistory(Long id) {
        OrderItem item = itemRepository.findById(id).get();

        ProductHistory history = new ProductHistory();
        history.setProduct(item.getProduct());
        history.setPrice(item.getUnitValue());
        history.setQuantity(item.getItemQuantity());
        history.setValidate(item.getItemValidate());
        historyRepository.saveAndFlush(history);

        return new ProductHistoryDTO(history);
    }
}
