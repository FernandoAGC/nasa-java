package com.nasa.prueba.aspirante.infraestructura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.prueba.aspirante.dominio.entities.NasaRecordEntity;

@Repository
public interface NasaRecordRepository extends JpaRepository<NasaRecordEntity, Long> {
    
    // obtener registros de manera descendiente por ID
    List<NasaRecordEntity> findAllByOrderByIdDesc();

}
