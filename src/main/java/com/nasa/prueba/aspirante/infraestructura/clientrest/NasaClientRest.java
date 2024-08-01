package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NasaClientRest {

    private final RestTemplate restTemplate;
    private static final String NASA_API_URL = "https://images-api.nasa.gov/search?q=apollo%2011";

    // consumir api rest
    public String getNasaData() {
        return restTemplate.getForObject(NASA_API_URL, String.class);
    }
    
}
