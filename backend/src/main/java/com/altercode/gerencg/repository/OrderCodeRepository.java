package com.altercode.gerencg.repository;

import com.altercode.gerencg.dto.SumOrderQuantityCategoryDTO;
import com.altercode.gerencg.dto.SumOrderValueCategoryDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.OrderStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCodeRepository extends JpaRepository<OrderCode, String> {

    @Query("SELECT obj FROM OrderCode obj WHERE obj.code LIKE %?1% ORDER BY obj.orderDate DESC")
    Page<OrderCode> findOrdersByCode(Pageable pageable, String code);

    Page<OrderCode> findOrdersByStats(Pageable pageable, OrderStats stats);

    @Query("SELECT new com.altercode.gerencg.dto.SumOrderValueCategoryDTO(obj.category, SUM(obj.totalValue))" +
            "FROM OrderCode AS obj GROUP BY obj.category ORDER BY SUM(obj.totalValue) DESC")
    List<SumOrderValueCategoryDTO> getOrderValueGroupByCategory();

    @Query("SELECT new com.altercode.gerencg.dto.SumOrderQuantityCategoryDTO(obj.category, SUM(obj.amountItems))" +
            "FROM OrderCode AS obj GROUP BY obj.category ORDER BY SUM(obj.amountItems) DESC")
    List<SumOrderQuantityCategoryDTO> getOrderQuantityGroupByCategory();


//    List<OrderCode> findAllOrdersByTag(String tagId);
}
