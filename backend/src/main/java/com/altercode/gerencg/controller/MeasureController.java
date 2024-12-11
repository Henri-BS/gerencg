package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.altercode.gerencg.dto.MeasureDTO;
import com.altercode.gerencg.service.interf.MeasureService;

@RestController
@RequestMapping("/measure")
public class MeasureController {
	
	@Autowired
	private MeasureService measureService;
	
	@GetMapping("/list")
	public Page<MeasureDTO> findMeasures(@RequestParam(defaultValue = "") String abbreviation, Pageable pageable){
		return measureService.findMeasures(abbreviation, pageable);
	}
	
	@GetMapping("/{id}")
	public MeasureDTO findById(@PathVariable String id){
		return measureService.findById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<MeasureDTO> saveMeasure(@RequestBody MeasureDTO dto) {
		MeasureDTO newMeasure = measureService.saveMeasure(dto);
		return new ResponseEntity<>(newMeasure, HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<MeasureDTO> updateMeasure(@RequestBody MeasureDTO dto) {
		MeasureDTO editMeasure = measureService.updateMeasure(dto);
		return new ResponseEntity<>(editMeasure, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMeasure(String id) {
		this.measureService.deleteMeasure(id);
	}
}
