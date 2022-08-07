package com.altercode.gerencg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, Long>{

}
