package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nasa.prueba.aspirante.dominio.dto.NasaDataDto;
import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaClientRest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaScheduledTask {
    
    private final NasaClientRest nasaClientRest;

    // Consumo programado de api rest cada minuto (60,000 milisegundos)
    @Scheduled(fixedRate = 60000)
    public void getApolo11NasaData() {
        // obtener datos de segun query param apollo 11
        NasaDataDto response = nasaClientRest.getNasaData("apollo 11");
        if (response != null && response.getCollection() != null && response.getCollection().getItems() != null && !response.getCollection().getItems().isEmpty()) {
            // obtener el primer item de items
            NasaDataDto.Collection.Item item = response.getCollection().getItems().get(0);
            if (item.getData() != null && !item.getData().isEmpty()) {
                // obtener el primer item de data
                NasaDataDto.Collection.Item.DataDto data = item.getData().get(0);
                System.out.println("Href: " + item.getHref());
                System.out.println("Center: " + data.getCenter());
                System.out.println("Title: " + data.getTitle());
                System.out.println("Nasa ID: " + data.getNasa_id());
            } else {
                System.out.println("No data found in the first item");
            }
        } else {
            System.out.println("No items found in the response");
        }
    }

}
