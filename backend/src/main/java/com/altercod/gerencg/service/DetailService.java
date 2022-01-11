package com.altercod.gerencg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altercod.gerencg.dto.DetailDTO;
import com.altercod.gerencg.entities.Detail;
import com.altercod.gerencg.repositories.CategoryRepository;
import com.altercod.gerencg.repositories.DetailRepository;

@Service
public class DetailService {
	
	@Autowired
	private DetailRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<DetailDTO> findAll(Pageable pageable){
		categoryRepository.findAll();	
		Page<Detail> result = repository.findAll(pageable);
			return result.map(x -> new DetailDTO(x));
	}
	
}
