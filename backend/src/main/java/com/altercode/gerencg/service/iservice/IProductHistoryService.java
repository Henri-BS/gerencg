package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductHistoryService {
    Page<ProductHistoryDTO> findAll(Pageable pageable);

    Page<ProductHistoryDTO> findByProduct(Pageable pageable, Product product);

    ProductHistoryDTO saveHistory(ProductHistoryDTO dto);

    ProductHistoryDTO saveItemInHistory(Long id);
}
