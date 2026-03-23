package com.example.movieApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//lo que ocnseguimos con esta clase es hacer que la respuesta pase por este cosntrucutor
//conviertendola en un objeto Movie como entidad
public class MovieResponseDTO {
    private  Long id;
    private String title;
    private String director;
    private Double duration;
    private Double rating;
}
