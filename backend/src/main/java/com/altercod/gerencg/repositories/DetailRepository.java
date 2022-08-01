package com.altercod.gerencg.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercod.gerencg.dto.CategoryFlowDTO;
import com.altercod.gerencg.dto.CategoryValueDTO;
import com.altercod.gerencg.entities.CategoryStats;

public interface DetailRepository extends JpaRepository<CategoryStats, Long>{

	@Query("SELECT new com.altercod.gerencg.dto.CategoryValueDTO(obj.category, SUM(obj.categoryValue)) "
			+ "FROM CategoryStats AS obj GROUP BY obj.category")
	List<CategoryValueDTO> valueGroupedByCategory();
	
	@Query("SELECT new com.altercod.gerencg.dto.CategoryFlowDTO(obj.category, SUM(obj.addedProducts), SUM(obj.removedProducts)) "
			+ "FROM CategoryStats AS obj GROUP BY obj.category")
	List<CategoryFlowDTO> flowGroupedByCategory();
}
