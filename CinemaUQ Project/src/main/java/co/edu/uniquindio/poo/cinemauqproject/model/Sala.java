package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sala {
    private final String id;
    private String nombre;
    private int filas, columnas;
    private final List<Asiento> asientos = new ArrayList<Asiento>();

    public Sala(String nombre, int filas, int columnas) {
        this.id = Ids.nuevo("SAL");
        this.nombre = nombre;
    }

    /** Metodo para distribuir los asientos */
    public void reconstruir(int filas, int columnas) {
        if (filas <=0 || columnas <= 0 || filas > 26)
            throw new ValidacionExcepcion("las filas deben estar en un rango de 1-26 y las columas deben ser mayor a 0");
        this.filas = filas;
        this.columnas = columnas;
        asientos.clear();
        for (int f = 0; f < this.filas; f++) {
            for (int c = 0; c < this.columnas; c++) {
                asientos.add(new Asiento((char) ('A' + f), c));
            }
        }
    }

    public void renombrar(String nombre) {
        if(nombre==null || nombre.isBlank()) throw new ValidacionExcepcion("Nombre de la sala es obligatorio");
        this.nombre = nombre;
    }
    public String id() {
        return id;
    }
    public String nombre() {
        return nombre;
    }
    public int filas() {
        return filas;
    }
    public int columnas() {
        return columnas;
    }
    public List<Asiento> asientos() {
        return Collections.unmodifiableList(asientos);
    }
    public int capacidad() {
        return asientos.size();
    }
}
