package com.altercode.gerencg.service;

import java.util.List;

import com.altercode.gerencg.entity.Category;
import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.ProductRepository;
import com.altercode.gerencg.service.iservice.ICategoryStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercode.gerencg.dto.CategoryStatsDTO;
import com.altercode.gerencg.dto.CategoryValueDTO;
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

		return result.map(x -> new CategoryStatsDTO(x));
	}

	@Override
	public List<CategoryValueDTO> priceGroupByCategory(){
		return productRepository.priceGroupByCategory();
	}

	@Override
	public CategoryStatsDTO saveStats(CategoryStatsDTO dto) {
		Category category = categoryRepository.findById(dto.getCategory()).get();

		CategoryStats add = new CategoryStats();
		add.setRegistrationDate(dto.getRegistrationDate());
		
		return new CategoryStatsDTO(statsRepository.saveAndFlush(add));
	}

	@Override
	public CategoryStatsDTO updateStats(CategoryStatsDTO dto) {
		
		CategoryStats stats = statsRepository.findById(dto.getId()).get();

		int sumQuantity = 0;
		double categoryValue = 0;

		for(Product i : stats.getCategory().getProducts()) {
			sumQuantity = sumQuantity + i.getQuantity();
			categoryValue = sumQuantity * i.getPrice();
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
