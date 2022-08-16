package com.altercode.gerencg.service;

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

	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = productRepository.findAll(pageable);
		Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
		return page;
	}

	public ProductDTO findById(Long id) {
		Product result = productRepository.findById(id).get();
		ProductDTO dto = new ProductDTO(result);
		return dto;
	}

	public ProductDTO addProduct(ProductDTO dto) {

		Category category = categoryRepository.findById(dto.getCategory()).get();
		Measure measure = measureRepository.findByDescription(dto.getMeasure()).get();
		
		Product add = new Product();
		add.setDescription(dto.getDescription());
		add.setImage(dto.getImage());
		add.setPrice(dto.getPrice());
		add.setQuantity(dto.getQuantity());
		add.setValidate(dto.getValidate());
		add.setCategory(category);
		add.setMeasureValue(dto.getMeasureValue());
		add.setMeasure(measure);

		category.setTotalProducts(category.getProducts().size());
		category = categoryRepository.save(category);

		return new ProductDTO(productRepository.saveAndFlush(add));
	}

	public ProductDTO updateProduct(ProductDTO dto) {

		Category category = categoryRepository.findById(dto.getCategory()).get();
		Measure measure = measureRepository.findByDescription(dto.getMeasure()).get();

		Product edit = productRepository.findById(dto.getId()).get();

		edit.setDescription(dto.getDescription());
		edit.setImage(dto.getImage());
		edit.setPrice(dto.getPrice());
		edit.setQuantity(dto.getQuantity());
		edit.setValidate(dto.getValidate());
		edit.setCategory(category);
		edit.setMeasure(measure);

		category.setTotalProducts(category.getProducts().size());
		category = categoryRepository.save(category);

		return new ProductDTO(productRepository.save(edit));
	}

	public void deleteProduct(Long id) {
		
		this.productRepository.deleteById(id);
	}
}
