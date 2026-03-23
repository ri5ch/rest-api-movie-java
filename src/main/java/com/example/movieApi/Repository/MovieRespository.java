package com.example.movieApi.Repository;

import com.example.movieApi.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
//vamos a utilizar una interfaz ya que no necesitamos crear todo de 0 , le pasaremos nuestra clase
//y nuestro identificador y  gracias a JPA spring simplemetne rellenara el crud con los datos
//que le hemos enviado

//enviamos nuestra Clsae y Long para que sepa la clave primaria v a ser de ese tipo
public interface MovieRespository extends JpaRepository<Movie,Long> {

}


//"Oye Spring,
// crea automáticamente:
//  - guardar pedidos
//- buscar por id
//- eliminar
//- actualizar
//- listar todos
// sin que yo escriba código"