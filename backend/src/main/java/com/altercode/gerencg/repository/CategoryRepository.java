package com.altercode.gerencg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

@Query("SELECT obj FROM Category obj WHERE UPPER(obj.name)" +
        "LIKE UPPER(CONCAT('%', ?1, '%')) ORDER BY (obj.name)")
    Page<Category> findCategories(String name, Pageable pageable);
}
