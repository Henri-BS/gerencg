package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CategoryProfileDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
     Page<CategoryProfileDTO> findAll(Pageable pageable);
     CategoryProfileDTO findById(String id);
     CategoryProfileDTO addCategory(CategoryProfileDTO dto);
     CategoryProfileDTO updateCategory(CategoryProfileDTO dto);
     void deleteCategory(String id);
}
