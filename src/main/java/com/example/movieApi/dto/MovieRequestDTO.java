package com.example.movieApi.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 150, message = "El título no puede superar los 150 caracteres")
    private String title;

    @NotBlank(message = "El nombre del director es obligatorio")
    private String director;

    @NotNull(message = "La duración no puede ser nula")
    @Positive(message = "La duración debe ser mayor a 0")
    private Double duration;

    @Min(value = 0, message = "El rating mínimo es 0")
    @Max(value = 10, message = "El rating máximo es 10")
    private Double rating;
}