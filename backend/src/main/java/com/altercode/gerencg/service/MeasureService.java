package com.altercode.gerencg.service;

import javax.transaction.Transactional;

import com.altercode.gerencg.service.interf.IMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.altercode.gerencg.dto.MeasureDTO;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.repository.MeasureRepository;

@Service
@Transactional
public class MeasureService implements IMeasureService {
	
	@Autowired
	private MeasureRepository measureRepository;
	
	
	public Page<MeasureDTO> findMeasures(String abbreviation, Pageable pageable) {
		Page<Measure> result = measureRepository.findMeasures(abbreviation, pageable);
		return result.map(MeasureDTO::new);
	}

	public MeasureDTO findById(String id) {
		Measure result = measureRepository.findById(id).get();
		return new MeasureDTO(result);
	}
	
	public MeasureDTO saveMeasure(MeasureDTO dto) {
		
		Measure add = new Measure();
		add.setDescription(dto.getDescription());
		add.setAbbreviation(dto.getAbbreviation());
		
		return new MeasureDTO(measureRepository.saveAndFlush(add));
	}
	
	public MeasureDTO updateMeasure(MeasureDTO dto) {
		
		Measure edit = measureRepository.findById(dto.getDescription()).get();
		
		edit.setDescription(dto.getDescription());
		edit.setAbbreviation(dto.getAbbreviation());
		
		return new MeasureDTO(measureRepository.save(edit));
	}
	
	public void deleteMeasure(String id) {
		this.measureRepository.deleteById(id);
	}

}
