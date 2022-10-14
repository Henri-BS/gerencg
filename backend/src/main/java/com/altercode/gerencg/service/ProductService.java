package com.altercode.gerencg.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import com.altercode.gerencg.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private MeasureRepository measureRepository;

	// Find all products by page and description

	public Page<ProductDTO> findAll(Pageable pageable, String description) {
		Page<Product> result = productRepository.findAll(pageable, description);
		Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
		return page;
	}

	// Find all products by page, minimum date and max date of validate

	public Page<ProductDTO> findAllByValidate(String minValidate, String maxValidate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min = minValidate.equals("") ? today.minusMonths(1) : LocalDate.parse(minValidate);
		LocalDate max = maxValidate.equals("") ? today.plusMonths(1) : LocalDate.parse(maxValidate);

		Page<Product> result = productRepository.findByValidate(min, max, pageable);
		Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
		return page;
	}

	// Find all products by page and category

	public Page<ProductDTO> findByCategory(Pageable pageable, Category category) {

		Page<Product> result = productRepository.findByCategory(pageable, category);
		Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
		return page;
	}

	// Find all products by page and measure

	public Page<ProductDTO> findByMeasure(Pageable pageable, Measure measure) {

		Page<Product> result = productRepository.findByMeasure(pageable, measure);
		Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
		return page;
	}

	// Find products by id

	public ProductDTO findById(Long id) {

		Product result = productRepository.findById(id).get();
		ProductDTO dto = new ProductDTO(result);
		return dto;
	}

	// Save new product

	public ProductDTO addProduct(ProductDTO dto) {

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

		LocalDate undefined = LocalDate.parse("Indeterminado");
		if (dto.getValidate() == null) {
			add.setValidate(undefined);
		}
		
		category.setTotalProducts(category.getProducts().size());
		category.setTotalRegisters(category.getCategoryStats().size());
		category = categoryRepository.save(category);

		return new ProductDTO(productRepository.saveAndFlush(add));
	}

	// Edit product

	public ProductDTO updateProduct(ProductDTO dto) {

		Category category = categoryRepository.findById(dto.getCategory()).get();
		Measure measure = measureRepository.findById(dto.getMeasure()).get();

		Product edit = productRepository.findById(dto.getId()).get();
		edit.setId(dto.getId());
		edit.setDescription(dto.getDescription());
		edit.setImage(dto.getImage());
		edit.setPrice(dto.getPrice());
		edit.setQuantity(dto.getQuantity());
		edit.setValidate(dto.getValidate());
		edit.setMeasureValue(dto.getMeasureValue());
		edit.setMeasure(measure);
		edit.setCategory(category);

		category.setTotalProducts(category.getProducts().size());
		category = categoryRepository.save(category);

		edit = productRepository.save(edit);

		return new ProductDTO(edit);
	}

	// Delete product

	public void deleteProduct(Long id) {
		this.productRepository.deleteById(id);
	}

}
