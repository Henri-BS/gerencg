package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.CommissionStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommissionStatsRepository extends JpaRepository<CommissionStats,  String> {

    @Query("SELECT obj FROM CommissionStats obj WHERE obj.id LIKE %?1%")
    List<CommissionStats> findAllStats(String id);

    @Query("SELECT obj FROM CommissionStats obj WHERE obj.id BETWEEN :initialDate AND :finalDate")
    List<CommissionStats> findCommissionsByPeriod(LocalDate initialDate, LocalDate finalDate);


}
