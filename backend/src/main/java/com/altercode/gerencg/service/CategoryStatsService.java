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
import com.altercode.gerencg.entity.CategoryStats;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.CategoryStatsRepository;

@Service
public class CategoryStatsService {
	
	@Autowired
	private CategoryStatsRepository repository;
	
	@Autowired
	private CategoryRepository ctrepository;
	
	@Transactional(readOnly = true)
	public Page<CategoryStatsDTO> findAll(Pageable pageable){
		ctrepository.findAll();
		Page<CategoryStats> result = repository.findAll(pageable);
		return result.map(x -> new CategoryStatsDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SumCategoryValuesDTO> valueGroupedByCategory(){
		return repository.valuesGroupedByCategory();
	}
	
	@Transactional(readOnly = true)
	public List<CategoryFlowDTO> flowGroupedByCategory(){
		return repository.flowGroupedByCategory();
	}
}
