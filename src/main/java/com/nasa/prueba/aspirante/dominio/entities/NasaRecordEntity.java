package com.nasa.prueba.aspirante.dominio.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nasa_records")
public class NasaRecordEntity {

    @Id // id autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String href;
    @Column(nullable = false)
    private String center;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String nasaId;

    // campo de auditoría para guardar la fecha y hora de creación del registro
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // obtener y asignar fecha y hora de creación antes de persitir
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    
}
