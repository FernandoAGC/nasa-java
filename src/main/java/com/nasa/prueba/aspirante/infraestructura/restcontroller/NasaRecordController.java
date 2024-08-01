package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.prueba.aspirante.dominio.dto.NasaRecordDto;
import com.nasa.prueba.aspirante.dominio.entities.NasaRecordEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.NasaRecordRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/nasa_records")
public class NasaRecordController {
    
    private final NasaRecordRepository nasaRecordRepository;

    @GetMapping("/apollo_11")
    public ResponseEntity<List<NasaRecordDto>> getAllRecordsApollo11() {
        // obtener datos de repositorio
        List<NasaRecordEntity> records = nasaRecordRepository.findAllByOrderByIdDesc();
        // convertir entidades en dtos
        List<NasaRecordDto> recordsDto = records.stream().map(record -> NasaRecordDto.builder()
            .id(record.getId())
            .href(record.getHref())
            .center(record.getCenter())
            .title(record.getTitle())
            .nasa_id(record.getNasaId())
            .created_at(record.getCreatedAt())
            .build()
        ).collect(Collectors.toList());

        return ResponseEntity.ok(recordsDto);
    }

}
