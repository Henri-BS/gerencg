package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
     Page<CategoryDTO> findAll(Pageable pageable);
     CategoryDTO findById(String id);
     CategoryDTO addCategory(CategoryDTO dto);
     CategoryDTO updateCategory(CategoryDTO dto);
     void deleteCategory(String id);
}
