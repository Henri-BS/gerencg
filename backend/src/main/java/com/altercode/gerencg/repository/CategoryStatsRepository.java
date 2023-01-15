package com.altercode.gerencg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercode.gerencg.dto.CategoryFlowDTO;
import com.altercode.gerencg.dto.CategoryValueDTO;
import com.altercode.gerencg.entity.CategoryStats;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryStatsRepository extends JpaRepository<CategoryStats, Long> {

}
