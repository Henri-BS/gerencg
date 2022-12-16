package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altercode.gerencg.entity.ProductHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<ProductHistory, Long>{

}
