package com.altercode.gerencg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.altercode.gerencg.dto.QuantityTimelineDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.ProductHistory;

public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>{

	@Query("SELECT new com.altercode.gerencg.dto.QuantityTimelineDTO(obj.product, SUM(obj.quantity))"
			+ "FROM ProductHistory AS obj GROUP BY obj.product")
	QuantityTimelineDTO getProductQuantityInHistory();

	Page<ProductHistory> findByProduct(Pageable pageable, Product product);
		
}
