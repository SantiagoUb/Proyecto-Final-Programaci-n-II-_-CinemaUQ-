package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

/** Composite (hoja) */

public record Producto(String id, String nombre, long precio) implements ItemMenu {
    public Producto {
        if (nombre == null || nombre.isBlank() || precio <= 0)
            throw new ValidacionExcepcion("El nombre y el precio son obligatorios");
    }

    @Override
    public String describir(String sangria) {
        return sangria + " - " + nombre + "  $" + precio;
    }
}
