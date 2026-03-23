package com.example.movieApi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //oye spring esta clase va a interceptar todas las excepsiones que ocurran en los controller
public class GlobalExceptionHandler {

//    EXCEPTION GLOBAL PARA VALIDACIONES
//    MethodArgumentNotValidException ,es un metodo de spring que nos devuelve los erroes
    @ExceptionHandler(MethodArgumentNotValidException.class) //cunado ocurra el error de VALIDACIONES ejecuta esta funcion/metodo
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) { //el parametro methodArgumetnValidExcep nos indica que fallo , que campo y el mensaje

        Map<String, String> errores = new HashMap<>(); //creamos un map para guaradar lo errrores ya que este lo que hace es converit los erroes en clave y valor

        ex.getBindingResult().getFieldErrors().forEach(error -> { //Obtenemos todos los errores de validación de los campos y los recorremos uno a uno
            errores.put(error.getField(), error.getDefaultMessage());// Guardamos cada error en el Map con formato: campo → mensaje
        });

        return ResponseEntity.badRequest().body(errores);// Devolvemos HTTP 400 junto con el Map; Spring lo convertirá automáticamente a JSON
    }
//EXCEPTION ID NO ENCONTRADO
// es una funcion creada por nosotros que llama a la clasr MovieNotdound que utiliza- un extensor de runtimeexception que nos permite:
//  lanzar un threw new error en el service siemore que ocurra este error

    @ExceptionHandler(MovieNotFoundException.class)//si ocurre movieNotFound en cualquier controller entra en este metodo y deja que construya la respeusta
    public ResponseEntity<Map<String, String>> handleMovieNotFound(MovieNotFoundException ex) {

        Map<String, String> error = Map.of("error", ex.getMessage()); //Creo un objeto con el mensaje del error
//        Formato: "error" → mensaje  ejem :"error": "Película no encontrada con id: 99"

        return ResponseEntity.status(404).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {

        Map<String, String> error = Map.of("error", "Error interno del servidor");

        return ResponseEntity.status(500).body(error);
    }
}
//VALIDACION

//Llega una petición con datos inválidos
//Spring valida porque hay @Valid
//Algo falla
//Spring lanza MethodArgumentNotValidException
//Spring busca quién maneja ese error
//Encuentra esta clase (@RestControllerAdvice)
//Encuentra este método (@ExceptionHandler)
//Entra en el método

//ID NO ENCONTRADO :

//Llega petición GET /movies/99
//Controller llama al service
//Service busca película
//No la encuentra
//Lanza MovieNotFoundException
//Spring detecta la excepción
//Busca handler global
//Encuentra este método
//Entra aquí