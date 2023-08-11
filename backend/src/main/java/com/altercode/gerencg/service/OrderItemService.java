package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.OrderRepository;
import com.altercode.gerencg.repository.OrderItemRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.interf.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private OrderRepository codeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<OrderItemDTO> findItems(Pageable pageable) {
        Page<OrderItem> result = itemRepository.findAll(pageable);

        double value;
        for (OrderItem i : result) {
            if(i.getCostValue() == null) {
                value = i.getTotalValue() / i.getItemQuantity();
                i.setCostValue(value);
            }
            if(i.getTotalValue() == null) {
                value = i.getCostValue() * i.getItemQuantity();
                i.setTotalValue(value);
            }
            if(i.getUnitValue() == null) {
                value = i.getCostValue() * 35 / 100 ;
                i.setUnitValue(value);
            }
        }

        return result.map(OrderItemDTO::new);
    }

    @Override
    public List<OrderItemDTO> findItemsByCode(Order code) {
        List<OrderItem> result = itemRepository.findItemsByCode(code);
        return result.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemDTO> findItemByProduct(Product product) {
        List<OrderItem> result = itemRepository.findItemByProduct(product);
        return result.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO findItemById(Long id) {
        OrderItem result = itemRepository.findById(id).get();
        return new OrderItemDTO(result);
    }

    @Override
    public OrderItemDTO saveItem(OrderItemDTO dto) {
        Product product = productRepository.findByDescription(dto.getProductDescription());
        Order code = codeRepository.findById(dto.getOrderCode()).get();

        OrderItem add = new OrderItem();
        add.setCode(code);
        add.setItemQuantity(dto.getQuantity());
        add.setPackageQuantity(dto.getPackageQuantity());
        add.setUnitValue(dto.getUnitValue());
        add.setTotalValue(dto.getTotalValue());
        add.setItemValidate(dto.getItemValidate());
        add.setProduct(product);

        code.setDateUpdated(LocalDateTime.now());
        codeRepository.save(code);

        return new OrderItemDTO(itemRepository.saveAndFlush(add));
    }

    @Override
    public OrderItemDTO updateItem(OrderItemDTO dto) {

        OrderItem edit = itemRepository.findById(dto.getId()).get();

        edit.setId(dto.getId());
        edit.setItemQuantity(dto.getQuantity());
        edit.setPackageQuantity(dto.getPackageQuantity());
        edit.setUnitValue(dto.getUnitValue());
        edit.setTotalValue(dto.getTotalValue());
        edit.setItemValidate(dto.getItemValidate());

        return new OrderItemDTO(itemRepository.save(edit));
    }

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public ProductDTO updateProductByItem(OrderItemDTO dto) {

        OrderItem item = itemRepository.findById(dto.getId()).get();
        int quantity = item.getItemQuantity();
        double price = item.getUnitValue();
        LocalDate validate = item.getItemValidate();
        LocalDateTime date = LocalDateTime.now();

        Product product = item.getProduct();
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setValidate(validate);
        product.setDateUpdated(date);
        productRepository.save(product);

        return new ProductDTO(product);
    }
}
