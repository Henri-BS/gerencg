package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.MeasureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMeasureService {
    Page<MeasureDTO> findAll(Pageable pageable);
    MeasureDTO findById(String id);
    MeasureDTO saveMeasure(MeasureDTO dto);
    MeasureDTO updateMeasure(MeasureDTO dto);
    void deleteMeasure(String id);
}
