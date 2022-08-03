package com.altercode.gerencg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.ProductDTO;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductDTO> findAll(Pageable pageable){
			Page<Product> result = productRepository.findAll(pageable);
			Page<ProductDTO> page = result.map(x -> new ProductDTO(x));
			return page;
	}

	public ProductDTO findById(Long id) {
		Product result = productRepository.findById(id).get();
		ProductDTO dto = new ProductDTO(result);
		return dto;	
		}
	
}
