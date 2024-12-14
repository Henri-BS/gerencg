package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.OrderItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Order;
import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.OrderRepository;
import com.altercode.gerencg.repository.OrderItemRepository;
import com.altercode.gerencg.repository.ProductRepository;
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
public class OrderItemServiceImpl implements com.altercode.gerencg.service.interf.OrderItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public void itemBaseValue() {
        double value;
        for (OrderItem i : itemRepository.findAll()) {
            if (i.getCostValue() == null) {
                value = i.getExpense() / i.getItemQuantity();
                i.setCostValue(value);
            }
            if (i.getExpense() == null) {
                value = i.getCostValue() * i.getItemQuantity();
                i.setExpense(value);
            }
            if(i.getIncome() == null) {
                value = i.getUnitValue() * i.getItemQuantity();
                i.setIncome(value);
            }
            itemRepository.save(i);
        }
    }

    @Override
    public Page<OrderItemDTO> findItems(Pageable pageable) {
        Page<OrderItem> result = itemRepository.findAll(pageable);
        itemBaseValue();
        return result.map(OrderItemDTO::new);
    }

    @Override
    public List<OrderItemDTO> findItemsByOrder(Order code) {
        List<OrderItem> result = itemRepository.findItemsByOrder(code);
        return result.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemDTO> findItemByProduct(Product product) {
        List<OrderItem> result = itemRepository.findItemsByProduct(product);
        return result.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO findItemById(Long id) {
        OrderItem result = itemRepository.findById(id).get();
        itemBaseValue();
        return new OrderItemDTO(result);
    }

    @Override
    public OrderItemDTO saveItem(OrderItemDTO dto) {
        Product product = productRepository.findByDescription(dto.getProductDescription());
        Order code = orderRepository.findById(dto.getOrderId()).get();

        OrderItem add = new OrderItem();
        add.setOrder(code);
        add.setItemQuantity(dto.getQuantity());
        add.setPackageQuantity(dto.getPackageQuantity());
        add.setUnitValue(dto.getUnitValue());
        add.setExpense(dto.getExpense());
        add.setItemValidate(dto.getItemValidate());
        add.setProduct(product);

        code.setDateUpdated(LocalDateTime.now());
        orderRepository.save(code);

        return new OrderItemDTO(itemRepository.saveAndFlush(add));
    }

    @Override
    public OrderItemDTO updateItem(OrderItemDTO dto) {

        OrderItem edit = itemRepository.findById(dto.getId()).get();
        Product product = productRepository.findByDescription(dto.getProductDescription());

        edit.setId(dto.getId());
        edit.setItemQuantity(dto.getQuantity());
        edit.setPackageQuantity(dto.getPackageQuantity());
        edit.setUnitValue(dto.getUnitValue());
        edit.setExpense(dto.getExpense());
        edit.setItemValidate(dto.getItemValidate());
        edit.setProduct(product);
        return new OrderItemDTO(itemRepository.save(edit));
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

    @Override
    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }
}
