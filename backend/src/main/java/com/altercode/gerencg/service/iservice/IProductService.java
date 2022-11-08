package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> findAll(Pageable pageable, String description);

    Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable);

    Page<ProductDTO> findByCategory(Pageable pageable, Category category);

    Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure);

    ProductDTO findById(Long id);

    ProductDTO saveProduct(ProductDTO dto);

    void deleteProduct(Long id);

}
