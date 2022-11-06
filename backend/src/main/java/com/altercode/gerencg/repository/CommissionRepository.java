package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.entity.Commission;
import com.altercode.gerencg.entity.CommissionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

    @Query("SELECT new com.altercode.gerencg.dto.CommissionResultsDTO(obj.code, SUM(obj.quantity), SUM(obj.totalValue)) "
            + "FROM Commission AS obj GROUP BY obj.code")
    List<CommissionResultsDTO> orderResults();

    List<Commission> findAllCommissionsByCode(CommissionCode code);

}
