package com.altercode.gerencg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.MeasureDTO;
import com.altercode.gerencg.service.MeasureService;

@RestController
@RequestMapping("/measure")
public class MeasureController {
	
	@Autowired
	private MeasureService measureService;
	
	@GetMapping("/list")
	public List<MeasureDTO> findAll(){
		return measureService.findAll();
	}
	
	@GetMapping("/{id}")
	public MeasureDTO findById(@PathVariable Long id){
		return measureService.findById(id);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<MeasureDTO> saveMeasure(@RequestBody MeasureDTO dto) {
		MeasureDTO newMeasure = measureService.saveMeasure(dto);
		return new ResponseEntity<MeasureDTO>(newMeasure, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<MeasureDTO> updateMeasure(@PathVariable Long id, @RequestBody MeasureDTO dto) {
		MeasureDTO editMeasure = measureService.updateMeasure(dto);
		return new ResponseEntity<>(editMeasure, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMeasure(Long id) {
		this.measureService.deleteMeasure(id);
	}
}
