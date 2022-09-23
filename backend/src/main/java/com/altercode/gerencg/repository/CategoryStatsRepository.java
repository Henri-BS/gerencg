package com.altercode.gerencg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercode.gerencg.dto.CategoryFlowDTO;
import com.altercode.gerencg.dto.CategoryValueDTO;
import com.altercode.gerencg.entity.CategoryStats;

public interface CategoryStatsRepository extends JpaRepository<CategoryStats, Long>{
	
	@Query("SELECT new com.altercode.gerencg.dto.CategoryFlowDTO(obj.category, SUM(obj.addedProducts), SUM(obj.removedProducts)) "
			+ "FROM CategoryStats AS obj GROUP BY obj.category" )
	List<CategoryFlowDTO> flowGroupedByCategory();
	
	@Query("SELECT new com.altercode.gerencg.dto.CategoryValueDTO(obj.category, SUM(obj.income), SUM(obj.expense))"
			+ "FROM CategoryStats AS obj GROUP BY obj.category")
			List<CategoryValueDTO> valuesGroupedByCategory();
	
}
