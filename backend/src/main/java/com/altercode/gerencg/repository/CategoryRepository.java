package com.altercode.gerencg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
	
}
