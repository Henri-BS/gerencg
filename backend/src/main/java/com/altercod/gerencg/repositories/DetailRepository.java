package com.altercod.gerencg.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercod.gerencg.dto.CategoryFlowDTO;
import com.altercod.gerencg.dto.CategoryValueDTO;
import com.altercod.gerencg.entities.Detail;

public interface DetailRepository extends JpaRepository<Detail, Long>{

	@Query("SELECT new com.altercod.gerencg.dto.CategoryValueDTO(obj.category, SUM(obj.upd_val)) "
			+ "FROM Detail AS obj GROUP BY obj.category")
	List<CategoryValueDTO> valueGroupedByCategory();
	
	@Query("SELECT new com.altercod.gerencg.dto.CategoryFlowDTO(obj.category, SUM(obj.prod_adc), SUM(obj.prod_remov)) "
			+ "FROM Detail AS obj GROUP BY obj.category")
	List<CategoryFlowDTO> flowGroupedByCategory();
}
