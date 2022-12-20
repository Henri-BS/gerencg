package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionItemRepository extends JpaRepository<CommissionItem, Long> {

    List<CommissionItem> findItemsByCode(CommissionCode code);

    List<CommissionItem> findItemByProduct(Product product);

}
