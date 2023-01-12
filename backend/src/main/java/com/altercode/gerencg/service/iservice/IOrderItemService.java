package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.OrderItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IOrderItemService {

    Page<OrderItemDTO> findAllItems(Pageable pageable);

    List<OrderItemDTO> findItemsByCode(OrderCode code);

    List<OrderItemDTO> findItemByProduct(Product product);

    OrderItemDTO findItemById(Long id);

    OrderItemDTO saveItem(OrderItemDTO dto);

    OrderItemDTO updateItem(OrderItemDTO dto);

    void deleteItem(Long id);

    ProductDTO updateProductByItem(OrderItemDTO dto);
}
