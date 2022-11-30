package com.altercode.gerencg.service.iservice;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.CommissionResultsDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.CommissionCode;
import com.altercode.gerencg.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommissionItemService {
    Page<CommissionItemDTO> findAllItems(Pageable pageable);

    List<CommissionItemDTO> findItemsByCode(CommissionCode code);

    List<CommissionItemDTO> findItemByProduct(Product product);

    CommissionItemDTO findItemById(Long id);

    CommissionItemDTO saveItem(CommissionItemDTO dto);

    CommissionItemDTO updateItem(CommissionItemDTO dto);

    void deleteItem(Long id);

    List<CommissionResultsDTO> commissionResults();

    ProductDTO updateProductByItem(CommissionItemDTO dto);

}
