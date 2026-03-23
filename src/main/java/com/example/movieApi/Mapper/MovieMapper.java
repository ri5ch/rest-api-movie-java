package com.example.movieApi.Mapper;

import com.example.movieApi.Model.Movie;
import com.example.movieApi.dto.MovieRequestDTO;
import com.example.movieApi.dto.MovieResponseDTO;

public class MovieMapper {

public static Movie toEntity(MovieRequestDTO dto){
    Movie movie=new Movie();
    movie.setTitle(dto.getTitle());
    movie.setDirector(dto.getDirector());
    movie.setDuration(dto.getDuration());
    movie.setRating(dto.getRating());
    return movie;
}
//vamosa  crear ahora to responsedto en ka que vamos a hacer que la entidad
//pase a ser una respeusta dto
//    utilizamos cosntructor aunque podriamos utilizar directmene los getter
//    y setter como en el de arriba
public static  MovieResponseDTO toresponseDTO(Movie movie){
    return new MovieResponseDTO(movie.getId(), movie.getTitle(), movie.getDirector(), movie.getDuration(), movie.getRating());
}
}
