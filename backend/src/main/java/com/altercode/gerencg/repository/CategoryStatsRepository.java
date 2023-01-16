package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.entity.CategoryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryStatsRepository extends JpaRepository<CategoryStats, Long> {

    @Query("SELECT new com.altercode.gerencg.dto.CategoryStatsTotalValueDTO (SUM(obj.income), MAX(obj.income))" +
            "FROM CategoryStats AS obj")
    public CategoryStatsTotalValueDTO getCategoryStatsTotalValue();
}
