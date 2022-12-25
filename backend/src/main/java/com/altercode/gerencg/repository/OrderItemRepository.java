package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findItemsByCode(OrderCode code);

    List<OrderItem> findItemByProduct(Product product);

}
