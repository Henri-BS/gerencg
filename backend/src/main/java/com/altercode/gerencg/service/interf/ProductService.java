package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<ProductDTO> findByDescription(Pageable pageable, String description);

    Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable);

    Page<ProductDTO> findByCategory(Pageable pageable, Category category);

    Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure);

    ProductDTO findById(Long id);

    ProductDTO findByDescription(String description);

    ProductDTO saveProduct(ProductDTO dto);

    void deleteProduct(Long id);

    ProductDTO updateProduct(ProductDTO product);

}
