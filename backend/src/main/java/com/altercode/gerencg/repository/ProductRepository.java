package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
