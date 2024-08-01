package com.nasa.prueba.aspirante.dominio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO para mapear los datos API REST de la NASA
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaDataDto {
    @JsonProperty("collection")
    private Collection collection;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Collection {
        @JsonProperty("items")
        private List<Item> items;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Item {
            @JsonProperty("href")
            private String href;
            @JsonProperty("data")
            private List<DataDto> data;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            @Builder
            public static class DataDto {
                @JsonProperty("center")
                private String center;
                @JsonProperty("title")
                private String title;
                @JsonProperty("nasa_id")
                private String nasa_id;
            }
        }
    }
}
