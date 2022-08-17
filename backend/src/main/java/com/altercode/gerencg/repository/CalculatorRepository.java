package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Calculator;

@Repository
public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

}
