package com.example.movieApi.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //le decimos a spring : oye esta clase va a ser una bbdd
@Table(name = "movies")//le decimos movie va a ser el nombre de la tabla
//getters & setters
@Getter
@Setter
//constructores
@AllArgsConstructor
@NoArgsConstructor


public class Movie {
    @Id //este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //generated vakue le dice a java estos id los dejo vacios , que el que sabe las normas
    //es la base de datos por lo que siga la estratgia de denracion de identidad de la base de datos
    private  Long id;
    private String title;
    private String director;
    private Double duration;
    private Double rating;
}
