package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CategoryFlowDTO;
import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.CategoryValueDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryStatsService {
    Page<CategoryStatsDTO> findAll(Pageable pageable);

    List<CategoryValueDTO> priceGroupByCategory();

    CategoryStatsDTO saveStats(CategoryStatsDTO dto);

    CategoryStatsDTO updateStats(CategoryStatsDTO dto);

    void deleteStats(Long id);

}
