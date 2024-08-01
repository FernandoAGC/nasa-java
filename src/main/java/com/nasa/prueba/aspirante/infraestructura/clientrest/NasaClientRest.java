package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nasa.prueba.aspirante.dominio.dto.NasaDataDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaClientRest {

    private final RestTemplate restTemplate;
    private static final String NASA_API_BASE_URL = "https://images-api.nasa.gov/search?q=";

    // consumir api rest
    public NasaDataDto getNasaData(String query) {
        String url = NASA_API_BASE_URL + query;
        return restTemplate.getForObject(url, NasaDataDto.class);
    }
    
}
