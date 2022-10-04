package com.altercode.gerencg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercode.gerencg.dto.QuantityTimelineDTO;
import com.altercode.gerencg.entity.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>{

	@Query("SELECT new com.altercode.gerencg.dto.QuantityTimelineDTO(obj.product, obj.quantity, obj.createdDate)"
			+ "FROM ProductHistory AS obj ")
	List<QuantityTimelineDTO> getProductQuantityInHistory();	
}
