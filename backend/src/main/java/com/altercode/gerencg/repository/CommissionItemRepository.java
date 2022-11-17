package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommissionItemRepository extends JpaRepository<CommissionItem, Long> {

    @Query("SELECT new com.altercode.gerencg.dto.CommissionResultsDTO(obj.code, SUM(obj.quantity), SUM(obj.totalValue)) "
            + "FROM CommissionItem AS obj GROUP BY obj.code")
    List<CommissionResultsDTO> commissionResults();

    List<CommissionItem> findAllCommissionsByCode(CommissionCode code);

    List<CommissionItem> findItemByProduct(Product product);


}
