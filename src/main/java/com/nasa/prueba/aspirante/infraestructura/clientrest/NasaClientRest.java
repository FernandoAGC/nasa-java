package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nasa.prueba.aspirante.dominio.dto.NasaDataDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaClientRest {

    private static final Logger logger = LoggerFactory.getLogger(NasaClientRest.class);
    private final RestTemplate restTemplate;
    private static final String NASA_API_BASE_URL = "https://images-api.nasa.gov/search?q=";

    // consumir api rest
    public NasaDataDto getNasaData(String query) {
        String url = NASA_API_BASE_URL + query;
        try {
            return restTemplate.getForObject(url, NasaDataDto.class);
        } catch (Exception e) {
            logger.error("Error while fetching data from NASA API: {}", e.getMessage());
            return null;
        }
    }
    
}
