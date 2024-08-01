package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nasa.prueba.aspirante.dominio.dto.NasaDataDto;
import com.nasa.prueba.aspirante.dominio.entities.NasaRecordEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaClientRest;
import com.nasa.prueba.aspirante.infraestructura.repository.NasaRecordRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaScheduledTask {
    
    private static final Logger logger = LoggerFactory.getLogger(NasaScheduledTask.class);
    private final NasaClientRest nasaClientRest;
    private final NasaRecordRepository nasaRecordRepository;

    // tarea programada de api rest externa de la nasa cada minuto (60,000 milisegundos)
    @Scheduled(fixedRate = 60000)
    public void getApolo11NasaData() {
        // obtener datos de segun query param apollo 11
        NasaDataDto response = nasaClientRest.getNasaData("apollo 11");
        if (response != null && response.getCollection() != null && response.getCollection().getItems() != null && !response.getCollection().getItems().isEmpty()) {
            // recorrer todo el arreglo items
            response.getCollection().getItems().forEach(item -> {
                if (item.getData() != null && !item.getData().isEmpty()) {
                    // obtener el primer item de data
                    NasaDataDto.Collection.Item.DataDto data = item.getData().get(0);
                    
                    // comprobacion si los datos no son nulos
                    if (item.getHref() != null && data.getCenter() != null && data.getTitle() != null && data.getNasa_id() != null) {
                        // almacenamiento de datos en BD
                            NasaRecordEntity record = NasaRecordEntity.builder()
                            .href(item.getHref())
                            .center(data.getCenter())
                            .title(data.getTitle())
                            .nasaId(data.getNasa_id())
                            .build();

                        try {
                            nasaRecordRepository.save(record);
                        } catch (Exception e) {
                            logger.error("Error while saving data to the database: {}", e.getMessage());
                        }
                    }
                } else {
                    logger.warn("No data found in the item");
                }
            });
        } else {
            logger.warn("No items found in the response");
        }
    }

}
