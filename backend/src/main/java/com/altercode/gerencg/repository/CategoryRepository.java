package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}
