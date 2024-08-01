package com.nasa.prueba.aspirante.dominio.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO para devolver en los response API REST
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NasaRecordDto {
    
    private Long id;
    private String href;
    private String center;
    private String title;
    private String nasa_id;
    private LocalDateTime created_at;

}
