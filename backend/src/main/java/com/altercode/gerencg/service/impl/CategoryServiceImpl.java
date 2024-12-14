package com.altercode.gerencg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.repository.CategoryRepository;


@Service
@Transactional
public class CategoryServiceImpl implements com.altercode.gerencg.service.interf.CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<CategoryDTO> findCategories(String name, Pageable pageable) {
		Page<Category> result = categoryRepository.findCategories(name, pageable);
		return result.map(CategoryDTO::new);
	}

	public CategoryDTO findById(String id) {

		Category category = categoryRepository.findById(id).get();
		category.setTotalProducts(category.getProducts().size());
		category.setTotalRegisters(category.getOrders().size());
		category = categoryRepository.save(category);

		return new CategoryDTO(category);
	}

	public CategoryDTO saveCategory(CategoryDTO dto) {

		Category add = new Category();
		add.setName(dto.getName());
		add.setImage(dto.getImage());

		Category category = categoryRepository.findById(dto.getName()).get();
		category.setTotalProducts(category.getProducts().size());
		categoryRepository.save(category);

		return new CategoryDTO(categoryRepository.saveAndFlush(add));
	}

	public CategoryDTO updateCategory(CategoryDTO dto) {

		Category edit = categoryRepository.findById(dto.getName()).get();
		edit.setName(dto.getName());
		edit.setImage(dto.getImage());
		edit.setTotalProducts(edit.getProducts().size());
		edit = categoryRepository.save(edit);

		return new CategoryDTO(categoryRepository.save(edit));
	}

	public void deleteCategory(String id) {
		this.categoryRepository.deleteById(id);
	}

}
