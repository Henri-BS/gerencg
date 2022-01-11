package com.altercod.gerencg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.altercod.gerencg.dto.DetailDTO;
import com.altercod.gerencg.entities.Detail;
import com.altercod.gerencg.repositories.DetailRepository;

@Service
public class DetailService {
	
	@Autowired
	private DetailRepository repository;
	
	public Page<DetailDTO> findAll(Pageable pageable){
			Page<Detail> result = repository.findAll(pageable);
			return result.map(x -> new DetailDTO(x));
	}
	
}
