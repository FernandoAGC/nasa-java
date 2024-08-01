package com.nasa.prueba.aspirante.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasa.prueba.aspirante.dominio.entities.NasaRecordEntity;

public interface NasaRecordRepository extends JpaRepository<NasaRecordEntity, Long> {
    
}
