package com.altercode.gerencg.service.impl;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import com.altercode.gerencg.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Service
@Transactional
public class ProductServiceImpl implements com.altercode.gerencg.service.interf.ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MeasureRepository measureRepository;

    private void productBaseValue(){
        for (Product p : productRepository.findAll()){
            if(p.getImage() == null) {
                p.setImage("https://cdn3.iconfinder.com/data/icons/design-thinking-4/64/Product_design_box_packaging-512.png");
            }
            productRepository.save(p);
        }
    }

    @Override
    public Page<ProductDTO> findByDescription(Pageable pageable, String description) {
        Page<Product> result = productRepository.findAllProducts( description, pageable);
        productBaseValue();
        return result.map(ProductDTO::new);
    }

    @Override
    public Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minValidate.equals("") ? today.minusMonths(1) : LocalDate.parse(minValidate);
        LocalDate max = maxValidate.equals("") ? today.plusMonths(1) : LocalDate.parse(maxValidate);

        Page<Product> result = productRepository.findByValidate(min, max, pageable);
        return result.map(ProductDTO::new);
    }

    @Override
    public Page<ProductDTO> findByCategory(Pageable pageable, Category category) {
        Page<Product> result = productRepository.findByCategory(pageable, category);

        return result.map(ProductDTO::new);
    }

    @Override
    public Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure) {
        Page<Product> result = productRepository.findByMeasure(pageable, measure);
        return result.map(ProductDTO::new);
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

        category.setTotalProducts(category.getProducts().size());
        category.setDateUpdated(LocalDateTime.now());
        categoryRepository.save(category);
        add.setCategory(category);

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
        edit.setDateUpdated(LocalDateTime.now());

        return new ProductDTO(productRepository.save(edit));
    }

    @Override
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
