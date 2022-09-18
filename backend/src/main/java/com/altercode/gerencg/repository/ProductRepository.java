package com.altercode.gerencg.repository;


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

	@Query("SELECT obj FROM Product obj WHERE obj.description LIKE %?1%")
	Page<Product> findByDescription(Pageable pageable, String description);
	
	Page<Product> findByCategory(Pageable pageable, Category category);
	
	Page<Product> findByMeasure(Pageable pageable, Measure measure);

}
