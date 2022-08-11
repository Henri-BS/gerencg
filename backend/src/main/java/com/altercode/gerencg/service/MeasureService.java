package com.altercode.gerencg.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altercode.gerencg.dto.MeasureDTO;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.repository.MeasureRepository;

@Service
@Transactional
public class MeasureService {
	
	@Autowired
	private MeasureRepository measureRepository;
	
	
	public List<MeasureDTO> findAll() {
		List<Measure> result = measureRepository.findAll();
		List<MeasureDTO> list = result.stream().map(x -> new MeasureDTO(x)).collect(Collectors.toList());
		return list;
	}

	public MeasureDTO findById(Long id) {
		Measure result = measureRepository.findById(id).get();
		MeasureDTO dto = new MeasureDTO(result);
		return dto;
	}
	
	public MeasureDTO saveMeasure(MeasureDTO dto) {
		
		Measure add = new Measure();
		add.setDescription(dto.getDescription());
		add.setValue(dto.getValue());
		add.setAbbreviation(dto.getAbbreviation());
		
		return new MeasureDTO(measureRepository.saveAndFlush(add));
	}
	
	public MeasureDTO updateMeasure(MeasureDTO dto) {
		
		Measure edit = measureRepository.findById(dto.getId()).get();
		
		edit.setDescription(dto.getDescription());
		edit.setValue(dto.getValue());
		edit.setAbbreviation(dto.getAbbreviation());
		
		return new MeasureDTO(measureRepository.save(edit));
	}
	
	public void deleteMeasure(Long id) {
		this.measureRepository.deleteById(id);
	}

}
