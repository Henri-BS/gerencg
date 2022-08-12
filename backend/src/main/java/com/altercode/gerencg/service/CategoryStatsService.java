package com.altercode.gerencg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryFlowDTO;
import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.SumCategoryValuesDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.CategoryStats;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.CategoryStatsRepository;

@Service
@Transactional
public class CategoryStatsService {
	
	@Autowired
	private CategoryStatsRepository statsRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Page<CategoryStatsDTO> findAll(Pageable pageable){
		categoryRepository.findAll();
		
		Page<CategoryStats> result = statsRepository.findAll(pageable);
		
		
		return result.map(x -> new CategoryStatsDTO(x));
	}
	
	public CategoryStatsDTO saveStats(CategoryStatsDTO dto) {
		
		Category category = categoryRepository.findById(dto.getId()).get(); 
		
		CategoryStats add = new CategoryStats();
		add.setRegistrationDate(dto.getRegistrationDate());
		add.setCategory(category);
		add.setAddedProducts(dto.getAddedProducts());
		add.setRemovedProducts(dto.getRemovedProducts());
		add.setIncome(dto.getIncome());
		add.setExpense(dto.getExpense());
	
		category.setTotalRegisters(category.getCategoryStats().size());
		category = categoryRepository.save(category);
		
		return new CategoryStatsDTO(statsRepository.saveAndFlush(add));
	}
	
	public CategoryStatsDTO updateStats(CategoryStatsDTO dto) {
		
		CategoryStats edit = statsRepository.findById(dto.getId()).get();
		Category category = categoryRepository.findById(dto.getId()).get();
		
		edit.setRegistrationDate(dto.getRegistrationDate());
		edit.setCategory(category);
		edit.setAddedProducts(dto.getAddedProducts());
		edit.setRemovedProducts(dto.getRemovedProducts());
		edit.setIncome(dto.getIncome());
		edit.setExpense(dto.getExpense());
		
		category.setTotalRegisters(category.getCategoryStats().size());
		category = categoryRepository.save(category);
		
		return new CategoryStatsDTO(statsRepository.save(edit));
	}
	
	public void deleteStats(Long id) {
		this.statsRepository.findById(id);
	}
	
	public List<SumCategoryValuesDTO> valueGroupedByCategory(){
		return statsRepository.valuesGroupedByCategory();
	}
	
	public List<CategoryFlowDTO> flowGroupedByCategory(){
		return statsRepository.flowGroupedByCategory();
	}
}
