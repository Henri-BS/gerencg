package com.altercode.gerencg.repository;

import java.time.LocalDate;
import java.util.List;

import com.altercode.gerencg.dto.SumCategoryQuantityDTO;
import com.altercode.gerencg.dto.SumCategoryValueDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

    Product findByDescription(String description);

    @Query("SELECT obj FROM Product obj WHERE obj.description LIKE %?1% ORDER BY obj.category ASC")
    Page<Product> findAllByDescription(Pageable pageable, String description);

    @Query("SELECT obj FROM Product obj WHERE obj.validate BETWEEN :min AND :max ORDER BY obj.validate DESC ")
    Page<Product> findByValidate(LocalDate min, LocalDate max, Pageable pageable);

    Page<Product> findByCategory(Pageable pageable, Category category);

    Page<Product> findByMeasure(Pageable pageable, Measure measure);

    @Query("SELECT new com.altercode.gerencg.dto.SumCategoryValueDTO (obj.category, SUM(obj.quantity * obj.price))" +
            "FROM Product AS obj GROUP BY obj.category ORDER BY SUM(obj.quantity * obj.price) DESC")
    List<SumCategoryValueDTO> productIncomeGroupByCategory();

    @Query("SELECT new com.altercode.gerencg.dto.SumCategoryQuantityDTO (obj.category, SUM(obj.quantity))" +
            "FROM Product AS obj GROUP BY obj.category ORDER BY SUM(obj.quantity) DESC")
    List<SumCategoryQuantityDTO> productQuantityGroupByCategory();
}