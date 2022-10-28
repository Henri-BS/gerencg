package com.altercode.gerencg.service;

import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.dto.ProductHistoryDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.ProductHistory;
import com.altercode.gerencg.repository.ProductHistoryRepository;
import com.altercode.gerencg.repository.ProductRepository;

@Service
@Transactional
public class ProductHistoryService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductHistoryRepository historyRepository;

	@Autowired
	private MeasureRepository measureRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<ProductHistoryDTO> findAll(Pageable pageable) {
		productRepository.findAll();
		Page<ProductHistory> result = historyRepository.findAll(pageable);
		return result.map(x -> new ProductHistoryDTO(x));
	}
	
		public Page<ProductHistoryDTO> findByProduct(Pageable pageable, Product product) {
		Page<ProductHistory> result = historyRepository.findByProduct(pageable, product);
		return result.map(x -> new ProductHistoryDTO(x));
	}

	public ProductDTO updateProduct(ProductHistoryDTO dto) {
		Product product = productRepository.findById(dto.getProductId()).get();
		Measure measure = measureRepository.findById(dto.getMeasure()).get();
		Category category = categoryRepository.findById(dto.getCategory()).get();

		ProductHistory history = new ProductHistory();
		history.setProduct(product);
		history.setDescription(dto.getDescription());
		history.setImage(dto.getImage());
		history.setPrice(dto.getPrice());
		history.setQuantity(dto.getQuantity());
		history.setValidate(dto.getValidate());
		history.setMeasureValue(dto.getMeasureValue());
		history.setMeasure(measure);
		history.setCategory(category);
		history.setCreatedDate(history.getCreatedDate());
		history = historyRepository.saveAndFlush(history);
		
		product.setDescription(history.getDescription());
		product.setImage(history.getImage());
		product.setPrice(history.getPrice());
		product.setQuantity(history.getQuantity());
		product.setValidate(history.getValidate());
		product.setMeasureValue(history.getMeasureValue());
		product.setMeasure(history.getMeasure());
		product.setCategory(history.getCategory());
		product.setAlteration(product.getAllHistory().size());
		product = productRepository.save(product);
		
		return new ProductDTO(product);
	}
}
