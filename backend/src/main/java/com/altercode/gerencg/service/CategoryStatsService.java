package com.altercode.gerencg.service;

import java.util.List;

import com.altercode.gerencg.dto.CategoryStatsTotalValueDTO;
import com.altercode.gerencg.dto.SumCategoryQuantityDTO;
import com.altercode.gerencg.dto.SumCategoryValueDTO;
import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.interfaceservice.ICategoryStatsService;
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
public class CategoryStatsService implements ICategoryStatsService {
	
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
	public List<SumCategoryValueDTO> productValueGroupByCategory(){
		return productRepository.productIncomeGroupByCategory();
	}

	@Override
	public List<SumCategoryQuantityDTO> productQuantityGroupByCategory(){
		return productRepository.productQuantityGroupByCategory();
	}

	@Override
	public CategoryStatsTotalValueDTO getCategoryStatsTotalValue(){
		return statsRepository.getCategoryStatsTotalValue();
	}

	@Override
	public CategoryStatsDTO saveStats(CategoryStatsDTO dto) {
		Category category = categoryRepository.findById(dto.getCategory()).get();

		CategoryStats add = new CategoryStats();
		add.setLastModifiedDate(dto.getLastModifiedDate());
		
		return new CategoryStatsDTO(statsRepository.saveAndFlush(add));
	}

	@Override
	public CategoryStatsDTO updateStats(CategoryStatsDTO dto) {
		CategoryStats stats = statsRepository.findById(dto.getId()).get();

		int sumQuantity = 0;
		double categoryValue = 0.0;

		for(Product i : stats.getCategory().getProducts()) {
			sumQuantity = sumQuantity + i.getQuantity();
			categoryValue = categoryValue + i.getIncome();
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
