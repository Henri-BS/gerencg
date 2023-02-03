package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.OrderItemRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.interfaceservice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private OrderItemRepository itemRepository;

    @Override
    public Page<ProductDTO> findAll(Pageable pageable, String description) {
        Page<Product> result = productRepository.findAll(pageable, description);
        return result.map(x -> new ProductDTO(x));
    }

    @Override
    public Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minValidate.equals("") ? today.minusMonths(1) : LocalDate.parse(minValidate);
        LocalDate max = maxValidate.equals("") ? today.plusMonths(1) : LocalDate.parse(maxValidate);

        Page<Product> result = productRepository.findByValidate(min, max, pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Override
    public Page<ProductDTO> findByCategory(Pageable pageable, Category category) {
        Page<Product> result = productRepository.findByCategory(pageable, category);

        return result.map(x -> new ProductDTO(x));
    }

    @Override
    public Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure) {
        Page<Product> result = productRepository.findByMeasure(pageable, measure);
        return result.map(x -> new ProductDTO(x));
    }

    @Override
    public ProductDTO findById(Long id) {
        Product result = productRepository.findById(id).get();
        double income = result.getPrice() * result.getQuantity();
        result.setIncome(income);
        return new ProductDTO(result);
    }

    @Override
    public ProductDTO findByDescription(String description) {
        Product result = productRepository.findByDescription(description);
        return new ProductDTO(result);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO dto) {

        Category category = categoryRepository.findById(dto.getCategory()).get();
        Measure measure = measureRepository.findById(dto.getMeasure()).get();

        Product add = new Product();
        add.setDescription(dto.getDescription());
        add.setImage(dto.getImage());
        add.setPrice(dto.getPrice());
        add.setQuantity(dto.getQuantity());
        add.setValidate(dto.getValidate());
        add.setMeasureValue(dto.getMeasureValue());
        add.setMeasure(measure);
        add.setCategory(category);

        category.setTotalProducts(category.getProducts().size());
        categoryRepository.save(category);

        return new ProductDTO(productRepository.saveAndFlush(add));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO dto) {
        Product edit = productRepository.findById(dto.getId()).get();
        Category category = categoryRepository.findById(dto.getCategory()).get();
        Measure measure = measureRepository.findById(dto.getMeasure()).get();

        edit.setDescription(dto.getDescription());
        edit.setPrice(dto.getPrice());
        edit.setQuantity(dto.getQuantity());
        edit.setValidate(dto.getValidate());
        edit.setMeasureValue(dto.getMeasureValue());
        edit.setMeasure(measure);
        edit.setCategory(category);

        return new ProductDTO(productRepository.save(edit));
    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
