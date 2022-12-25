package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatsRepository extends JpaRepository<OrderStats,  String> {

    @Query("SELECT obj FROM OrderStats obj WHERE obj.id LIKE %?1%")
    List<OrderStats> findAllStats(String id);

}
