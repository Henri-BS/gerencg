package com.altercode.gerencg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.ProductHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>{

	Page<ProductHistory> findByProduct(Pageable pageable, Product product);
		
}
