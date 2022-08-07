package com.altercode.gerencg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryDTO;
import com.altercode.gerencg.dto.CategoryProfileDTO;
import com.altercode.gerencg.dto.RegisterDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.entity.Register;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.repository.RegisterRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public List<CategoryDTO> findAll(){
			List<Category> result = categoryRepository.findAll();
			return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	public CategoryDTO findById(Long id) {
		Category result = categoryRepository.findById(id).get();
		CategoryDTO dto = new CategoryDTO(result);
		return dto;	
		}
	
	public CategoryDTO addCategory(CategoryDTO dto) {
		
		Category add = new Category();
		add.setName(dto.getName());
		
		Category save = categoryRepository.saveAndFlush(add);
		return new CategoryDTO(save);
	}
	
	public CategoryDTO updateCategory(CategoryDTO dto) {
		
		Category edit = categoryRepository.findById(dto.getId()).get();
		
		edit.setId(dto.getId());
		edit.setName(dto.getName());
		
		Category update = categoryRepository.save(edit);
		return new CategoryDTO(update);
	}
	
	public void deleteCategory(Long id) {
		this.categoryRepository.deleteById(id);
	}
	
	public CategoryProfileDTO totalProducts(RegisterDTO dto) {
		
		Category category = categoryRepository.findById(dto.getCategoryId()).get();
		Product product = productRepository.findById(dto.getProductId()).get();
		
		Register register = new Register();
		register.setCategory(category);
		register.setProduct(product);
		register = registerRepository.saveAndFlush(register);
		
		int result = 1;
		for(Register r : category.getProductRegister()) {
			result = result + r.getValue();
		}
		
		int total = category.getTotalProducts();
		total = total + result;
		
		category.setTotalProducts(total);
		category = categoryRepository.save(category);
		
		return new CategoryProfileDTO(category);
	}
}
