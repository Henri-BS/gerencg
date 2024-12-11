package com.altercode.gerencg.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.entity.CategoryStats;
import com.altercode.gerencg.repository.CategoryRepository;
import com.altercode.gerencg.repository.CategoryStatsRepository;

@Service
@Transactional
public class CategoryStatsServiceImpl implements com.altercode.gerencg.service.interf.CategoryStatsService {
	
	@Autowired
	private CategoryStatsRepository statsRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Page<CategoryStatsDTO> findAll(Pageable pageable){
		categoryRepository.findAll();
		Page<CategoryStats> result = statsRepository.findAll(pageable);

		return result.map(CategoryStatsDTO::new);
	}

	@Override
	public CategoryStatsDTO findByCategory(Category category) {
		CategoryStats find = statsRepository.findByCategory(category);
		return new CategoryStatsDTO(find);
	}

	@Override
	public List<CategoryStatsTotalValueDTO> productValueGroupByCategory(){
		return productRepository.productIncomeGroupByCategory();
	}

	@Override
	public List<CategoryStatsTotalValueDTO> productQuantityGroupByCategory(){
		return productRepository.productQuantityGroupByCategory();
	}

	@Override
	public CategoryStatsTotalValueDTO getCategoryStatsTotalValue(){
		return statsRepository.getCategoryStatsTotalValue();
	}

	@Override
	public CategoryStatsDTO saveStats(CategoryStatsDTO dto) {

		CategoryStats add = new CategoryStats();
		add.setLastModifiedDate(LocalDateTime.now());
		
		return new CategoryStatsDTO(statsRepository.saveAndFlush(add));
	}

	@Override
	public CategoryStatsDTO updateStats(CategoryStatsDTO dto) {
		CategoryStats stats = statsRepository.findById(dto.getId()).get();

		int sumQuantity = 0;
		double categoryValue = 0.0;

		for(Product i : stats.getCategory().getProducts()) {
			sumQuantity += i.getQuantity();
			categoryValue += i.getIncome();
		}

		stats.setCategory(stats.getCategory());
		stats.setAddedProducts(sumQuantity);
		stats.setIncome(categoryValue);

		return new CategoryStatsDTO(statsRepository.save(stats));
	}

	@Override
	public void deleteStats(Long id) {
		this.statsRepository.findById(id);
	}

}
