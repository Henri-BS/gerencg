package com.altercode.gerencg.repository;

import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderTag;
import com.altercode.gerencg.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTagRepository extends JpaRepository<OrderTag, Long> {
    List<OrderTag> findByTag(Tag tag);

    List<OrderTag> findByOrder(Order order);

}
