package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

public record Pelicula(String id, String titulo, String genero, int duracionMin, String clasificacion) {
    public Pelicula {
        if(titulo == null || titulo.isBlank())
            throw new ValidacionExcepcion("El titulo es obligatorio");
        if(duracionMin <= 30)
            throw new ValidacionExcepcion("El duracion de la pelicula debe ser mayor a 30 minutos");
    }
}
