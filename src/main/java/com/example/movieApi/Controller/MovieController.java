package com.example.movieApi.Controller;
import com.example.movieApi.Mapper.MovieMapper;
import com.example.movieApi.Model.Movie;
import com.example.movieApi.Service.MovieService;
import com.example.movieApi.dto.MovieRequestDTO;
import com.example.movieApi.dto.MovieResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

//declaramos como elemento
private final MovieService movieService;

//contrstrucotr
public MovieController(MovieService movieService){
        this.movieService=movieService;
    }
//metodos/gestor http;
@GetMapping
    public ResponseEntity<List<MovieResponseDTO>> listarPeliculas(){
        List<Movie> peliculas=movieService.gettALLMovies();//ahora tengo dentro de peliculas la lsita con las etniades y queiero conberitlas par apoder pasarlas
//        oye mete dentro de la lsita moviereposne esta lista convertida gracias a mapper
        List<MovieResponseDTO> listaPelis=peliculas.stream().map(MovieMapper::toresponseDTO).toList();
        return  ResponseEntity.ok(listaPelis);
}
@PostMapping
    public ResponseEntity<MovieResponseDTO> crearPeliController(@Valid  @RequestBody MovieRequestDTO solicitados){

    Movie movie=MovieMapper.toEntity(solicitados);
    Movie peliCreada=movieService.createMovie(movie);
    MovieResponseDTO respuestadto= MovieMapper.toresponseDTO(peliCreada);
    return ResponseEntity.ok(respuestadto);
}
@GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO>obtenerIdController(@PathVariable Long id){

    Movie movie = movieService.getMoviebyID(id);
    MovieResponseDTO respuesta=MovieMapper.toresponseDTO(movie);
    return ResponseEntity.ok(respuesta);
}
@PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO>actualizarController(@PathVariable Long id , @Valid @RequestBody MovieRequestDTO request ){

    Movie movie = MovieMapper.toEntity(request); //paso el objeto json reicibido a entidad
    Movie peliActuazliazada=movieService.updateMovie(id,movie); //le digo que pelicula del la entidad lelicual ser la peli acuzalizada pasandole los datos
//    ahora necesto convertir esta entidad que me devuvlve service mediante peliactualziada y convertirla en objeton aprta envair por json
    MovieResponseDTO respuesta=MovieMapper.toresponseDTO(peliActuazliazada);
    return ResponseEntity.ok(respuesta);
}
@DeleteMapping("/{id}")
    public ResponseEntity<MovieResponseDTO>eliminarPeli(@PathVariable Long id){

    movieService.deleteMovie(id);
    return ResponseEntity.noContent().build();
}
}
