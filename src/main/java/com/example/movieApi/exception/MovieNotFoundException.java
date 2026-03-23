package com.example.movieApi.exception;

public class MovieNotFoundException  extends  RuntimeException{
//constructor
    public MovieNotFoundException(String mensaje){
        super(mensaje);
    }
}
