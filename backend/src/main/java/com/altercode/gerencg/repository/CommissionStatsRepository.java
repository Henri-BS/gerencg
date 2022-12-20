package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.CommissionStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionStatsRepository extends JpaRepository<CommissionStats,  String> {
}
