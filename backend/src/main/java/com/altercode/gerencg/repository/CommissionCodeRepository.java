package com.altercode.gerencg.repository;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommissionCodeRepository extends JpaRepository<CommissionCode, String> {

@Query("SELECT obj FROM CommissionCode obj WHERE obj.code LIKE %?1%")
Page<CommissionCode> findCommissionsByCode(Pageable pageable, String code);

    @Query("SELECT obj FROM CommissionCode obj WHERE obj.commissionDate BETWEEN :min AND :max ")
    List<CommissionCode> findByCommissionDate(LocalDate min, LocalDate max);

    List<CommissionCode> findComissionsByStats(String stats);
}
