package com.altercode.gerencg.service.interfaceservice;

import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductHistoryService {
    Page<ProductHistoryDTO> findAll(Pageable pageable);

    Page<ProductHistoryDTO> findByProduct(Pageable pageable, Product product);

    ProductHistoryDTO saveHistory(ProductHistoryDTO dto);

    ProductHistoryDTO saveItemHistory(Long id);

    ProductHistoryDTO updateHistory(ProductHistoryDTO dto);

    ProductHistoryDTO updateProductHistoryValue(ProductHistoryDTO dto);

    void deleteProductHistory(Long id);

    ProductHistoryDTO findHistoryById(Long id);
}
