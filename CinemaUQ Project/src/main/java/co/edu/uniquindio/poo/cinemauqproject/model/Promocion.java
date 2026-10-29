package co.edu.uniquindio.poo.cinemauqproject.model;

import java.time.LocalDate;

/** Decisión: una sola promoción por compra, porcentaje sobre el subtotal. */

public record Promocion(String codigo, String nombre, int porcentaje, LocalDate desde, LocalDate hasta) {
    public boolean vigente(LocalDate hoy) {
        return !hoy.isAfter(desde) && hoy.isBefore(hasta);
    }
}
