package com.altercode.gerencg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryProfileDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryProfileDTO> findAll(){
			List<Category> result = categoryRepository.findAll();
			return result.stream().map(x -> new CategoryProfileDTO(x)).collect(Collectors.toList());
	}

	public CategoryProfileDTO findById(Long id) {
		Category result = categoryRepository.findById(id).get();
		CategoryProfileDTO dto = new CategoryProfileDTO(result);
		return dto;	
		}
	
	public CategoryProfileDTO addCategory(CategoryProfileDTO dto) {
		
		Category add = new Category();
		add.setName(dto.getName());
		add.setImage(dto.getImage());
		add.setTotalProducts(dto.getTotalProducts());
		
		return new CategoryProfileDTO(categoryRepository.saveAndFlush(add));
	}
	
	public CategoryProfileDTO updateCategory(CategoryProfileDTO dto) {
		
		Category edit = categoryRepository.findById(dto.getId()).get();
		
		edit.setId(dto.getId());
		edit.setName(dto.getName());
		edit.setImage(dto.getImage());
		edit.setTotalProducts(dto.getTotalProducts());
		
		Category update = categoryRepository.save(edit);
		return new CategoryProfileDTO(update);
	}
	
	public void deleteCategory(Long id) {
		this.categoryRepository.deleteById(id);
	}
	
	
}
