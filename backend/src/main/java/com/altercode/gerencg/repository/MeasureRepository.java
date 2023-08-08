package com.altercode.gerencg.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Measure;

@Repository
public interface MeasureRepository extends JpaRepository<Measure, String>{

    Optional<Measure> findByAbbreviation(String abbreviation);

    @Query("SELECT obj FROM Measure obj WHERE UPPER(obj.abbreviation) " +
            "LIKE UPPER(CONCAT('%', ?1, '%')) ORDER BY (obj.abbreviation)")
    Page<Measure> findMeasures(String abbreviation, Pageable pageable);
}