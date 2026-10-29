package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

public class ConExtra extends DecoradorItem {
    private final String extra;
    private final long recargo;
    public ConExtra(ItemMenu base, String extra, long recargo) {
        super(base);
        if(recargo <= 0) throw new ValidacionExcepcion("El recargo del complmento debe ser mayor que 0");
        this.extra = extra;
        this.recargo = recargo;
    }

    @Override
    public String nombre() {
        return super.nombre() + " + " + extra;
    }

    @Override
    public long precio() {
        return super.precio() + recargo;
    }
}
