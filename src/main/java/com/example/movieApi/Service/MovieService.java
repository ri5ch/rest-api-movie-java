package com.example.movieApi.Service;

import com.example.movieApi.Model.Movie;
import com.example.movieApi.Repository.MovieRespository;
import com.example.movieApi.exception.MovieNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private MovieRespository movieRespository;
//    constructor
    public MovieService(MovieRespository movieRespository){
        this.movieRespository=movieRespository;
    }

//    Metodos Crud:
    public List<Movie> gettALLMovies(){
        return movieRespository.findAll();
    }
    public Movie createMovie(Movie movie){
        return  movieRespository.save(movie);
    }

    public Movie getMoviebyID(Long id){
        return movieRespository.findById(id).orElseThrow(()->new MovieNotFoundException("movie not found with id: "+id));
    }

    @Transactional
    public Movie updateMovie(Long id , Movie data){

        Movie movie=getMoviebyID(id);
        movie.setTitle(data.getTitle());
        movie.setDirector(data.getDirector());
        movie.setDuration(data.getDuration());
        movie.setRating(data.getRating());

        return movieRespository.save(movie);
    }

    public void deleteMovie(Long id){
        Movie movie= movieRespository.findById(id).orElseThrow(()->new MovieNotFoundException("movie not found with id: "+id));

        movieRespository.delete(movie);
    }


















// ------------------------   FORMAA SIN BBDD----------------------------------------------
    //aqui tengo que crear los metodos de la bbdd , la tengo que simular porque aun no la tenmos
//por lo que creamos una lista de movies
//    List<Movie> peliculas = new ArrayList<>();
//    Long id = 1L; //declaramos id
//
//    //METODOS:
//    public List<Movie> listarPeliculas() {
//        return peliculas;
//    }
//
//    public Movie crearPelicula(Movie movie) {
//        movie.setId(id);
//        id++;
//        peliculas.add(movie);
//        return movie;
//    }
//
//    public Movie obtenerPeliculaPorId(Long id) {
//        for (int i = 0; i < peliculas.size(); i++) {
//            Movie movie = peliculas.get(i);
//            if (movie.getId().equals(id)) {
//                return movie;
//            }
//        }
//        throw  new RuntimeException("pelicula no encontrada con id:"+id);
//    }
//
//    public void eliminarPelicula(Long id) {
//        Movie movieId = obtenerPeliculaPorId(id);
//            peliculas.remove(movieId);
//    }
//    public Movie actualizarPelicula(Long id,Movie datosAct){
//        Movie movieId=obtenerPeliculaPorId(id);
//
//        movieId.setId(datosAct.getId());
//        movieId.setDuration(datosAct.getDuration());
//        movieId.setDirector(datosAct.getDirector());
//        movieId.setTitle(datosAct.getTitle());
//        movieId.setRating(datosAct.getRating());
//        return movieId;
//    }
}

//Llega petición GET /movies/99
//Controller llama al service
//Service busca película
//No la encuentra
//Lanza MovieNotFoundException
//Spring detecta la excepción
//Busca handler global
//Encuentra este método
//Entra aquí