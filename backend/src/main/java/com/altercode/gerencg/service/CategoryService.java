package com.altercode.gerencg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll(){
			List<Category> result = repository.findAll();
			return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}

	public CategoryDTO findById(Long id) {
		Category result = repository.findById(id).get();
		CategoryDTO dto = new CategoryDTO(result);
		return dto;	
		}
	
	public CategoryDTO addCategory(CategoryDTO dto) {
		
		Category add = new Category();
		add.setId(dto.getId());
		add.setName(dto.getName());
		
		Category category = repository.saveAndFlush(add);
		return new CategoryDTO(category);
	}
	
}
