# rest-api-movie-java
# Spring Boot Movie CRUD API

Este proyecto es una API REST básica desarrollada con Java y Spring Boot que permite realizar operaciones CRUD sobre una entidad Movie.

Forma parte de mi reto personal de programar cada día hasta conseguir una oportunidad como Java Backend Developer.

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Funcionalidades

La API permite:

- Crear una película
- Obtener todas las películas
- Obtener una película por id
- Actualizar una película
- Eliminar una película

## Estructura del proyecto

El proyecto sigue una arquitectura básica en capas:

- Controller → maneja las peticiones HTTP
- Service → contiene la lógica de negocio
- Repository → acceso a la base de datos
- Model → entidad Movie

## Base de datos

Se utiliza H2, una base de datos en memoria ideal para desarrollo y testing.

La consola H2 está disponible en:

http://localhost:8080/h2-console

## Cómo ejecutar el proyecto

1. Clonar el repositorio

git clone https://github.com/ri5ch/rest-api-movie-java.git

2. Entrar en el proyecto

cd movieApi

3. Ejecutar

./mvnw spring-boot:run

## Endpoints

GET /movies  
POST /movies  
GET /movies/{id}  
PUT /movies/{id}  
DELETE /movies/{id}

## Próximas mejoras

- Relacionar con otras entidades
- Conexion a Mysql
- Dockerizar proyecto
- tests
- conexión a Postgre
- documentación con Swagger

## Autor

Desarrollado como parte de mi serie de aprendizaje diario en Java.
