package com.altercode.gerencg.service.interfaceservice;

import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.SumCategoryQuantityDTO;
import com.altercode.gerencg.dto.SumCategoryValueDTO;
import com.altercode.gerencg.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryStatsService {
    Page<CategoryStatsDTO> findAll(Pageable pageable);

    List<SumCategoryValueDTO> productValueGroupByCategory();

    List<SumCategoryQuantityDTO> productQuantityGroupByCategory();

    CategoryStatsTotalValueDTO getCategoryStatsTotalValue();

    CategoryStatsDTO saveStats(CategoryStatsDTO dto);

    CategoryStatsDTO updateStats(CategoryStatsDTO dto);

    void deleteStats(Long id);

    CategoryStatsDTO findByCategory(Category category);
}
