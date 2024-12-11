package com.altercode.gerencg.service.interf;

import com.altercode.gerencg.dto.MeasureDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MeasureService {
    Page<MeasureDTO> findMeasures(String abbreviation, Pageable pageable);
    MeasureDTO findById(String id);
    MeasureDTO saveMeasure(MeasureDTO dto);
    MeasureDTO updateMeasure(MeasureDTO dto);
    void deleteMeasure(String id);
}
