package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nasa.prueba.aspirante.infraestructura.clientrest.NasaClientRest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaScheduledTask {
    
    private final NasaClientRest nasaClientRest;

    // Consumo de api rest cada minuto (60,000 milisegundos)
    @Scheduled(fixedRate = 60000)
    public void fetchNasaData() {
        String data = nasaClientRest.getNasaData();
        System.out.println(data);
    }

}
