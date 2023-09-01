package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryStatsService {
    Page<CategoryStatsDTO> findAll(Pageable pageable);

    List<CategoryStatsTotalValueDTO> productValueGroupByCategory();

    List<CategoryStatsTotalValueDTO> productQuantityGroupByCategory();

    CategoryStatsTotalValueDTO getCategoryStatsTotalValue();

    CategoryStatsDTO saveStats(CategoryStatsDTO dto);

    CategoryStatsDTO updateStats(CategoryStatsDTO dto);

    void deleteStats(Long id);

    CategoryStatsDTO findByCategory(Category category);
}
