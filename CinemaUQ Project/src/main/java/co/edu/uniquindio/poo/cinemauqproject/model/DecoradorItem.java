package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

/** PATRÓN DECORATOR (base): agrega complementos a un producto sin una subclase por combinación. */

public abstract class DecoradorItem implements ItemMenu {
    protected final ItemMenu base;

    protected DecoradorItem(ItemMenu base) {
        if(base == null) throw new ValidacionExcepcion("Producto base obligatorio");
        if(base instanceof Combo) throw new ValidacionExcepcion("Los combos tienen composicion y precio cerrados. No se admiten complementos");
        this.base = base;
    }

    @Override
    public String nombre() {
        return base.nombre();
    }

    @Override
    public long precio() {
        return base.precio();
    }

    @Override
    public String describir(String sangria) {
        return sangria + "- " + nombre() + " $" + precio();
    }
}
