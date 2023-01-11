package com.altercode.gerencg.repository;


import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

	Product findByDescription(String description);

	@Query("SELECT obj FROM Product obj WHERE obj.description LIKE %?1% ORDER BY obj.description ASC")
	Page<Product> findAll(Pageable pageable, String description);
	
	@Query("SELECT obj FROM Product obj WHERE obj.validate BETWEEN :min AND :max ORDER BY obj.validate DESC ")
	Page<Product> findByValidate(LocalDate min, LocalDate max, Pageable pageable);
	
	Page<Product> findByCategory(Pageable pageable, Category category);
	
	Page<Product> findByMeasure(Pageable pageable, Measure measure);
}