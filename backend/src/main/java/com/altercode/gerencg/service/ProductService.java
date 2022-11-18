package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.CommissionItemDTO;
import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.CommissionItem;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.CommissionItemRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.IProductService;
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
    private CommissionItemRepository itemRepository;

    // Find all products by page and description

    public Page<ProductDTO> findAll(Pageable pageable, String description) {
        Page<Product> result = productRepository.findAll(pageable, description);
        return result.map(x -> new ProductDTO(x));
    }

    // Find all products by page, minimum date and max date of validate
    public Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minValidate.equals("") ? today.minusMonths(1) : LocalDate.parse(minValidate);
        LocalDate max = maxValidate.equals("") ? today.plusMonths(1) : LocalDate.parse(maxValidate);

        Page<Product> result = productRepository.findByValidate(min, max, pageable);
        return result.map(x -> new ProductDTO(x));
    }

    // Find all products by page and category
    public Page<ProductDTO> findByCategory(Pageable pageable, Category category) {

        Page<Product> result = productRepository.findByCategory(pageable, category);
        return result.map(x -> new ProductDTO(x));
    }

    // Find all products by page and measure
    public Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure) {

        Page<Product> result = productRepository.findByMeasure(pageable, measure);
        return result.map(x -> new ProductDTO(x));
    }

    // Find products by id
    public ProductDTO findById(Long id) {
        Product result = productRepository.findById(id).get();

        return new ProductDTO(result);
    }

    // Save new product
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
        category.setTotalRegisters(category.getCategoryStats().size());
        categoryRepository.save(category);

        return new ProductDTO(productRepository.saveAndFlush(add));
    }

    // Delete product
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    public ProductDTO updateProductByCommission(CommissionItemDTO dto) {
        Product product = productRepository.findById(dto.getProduct()).get();

        int sumQuantity = product.getQuantity();
        for (CommissionItem c : product.getOrders()) {
            sumQuantity = sumQuantity + c.getItemQuantity();
        }

        product.setQuantity(sumQuantity);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }
}
