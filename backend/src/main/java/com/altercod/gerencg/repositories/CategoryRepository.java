package com.altercod.gerencg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altercod.gerencg.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
