package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
     Page<CategoryDTO> findCategories(String name, Pageable pageable);
     CategoryDTO findById(String id);
     CategoryDTO saveCategory(CategoryDTO dto);
     CategoryDTO updateCategory(CategoryDTO dto);
     void deleteCategory(String id);
}
