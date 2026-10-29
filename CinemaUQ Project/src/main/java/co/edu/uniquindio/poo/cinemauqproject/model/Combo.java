package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Composite (compuesto). El precio se calcula una sola vez: suma de componentes menos descuento (sin doble conteo). */

public class Combo implements ItemMenu {
    private final String id, nombre;
    private final int descuento;
    private final List<ItemMenu> productos = new ArrayList<ItemMenu>();

    public Combo(String nombre, int descuento) {
        if (descuento < 0 || descuento > 100) throw new ValidacionExcepcion("Descuento invalido");
        this.id = Ids.nuevo("CMB");
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public Combo agregar(ItemMenu item) {
        if (item == this || item instanceof Combo combo && combo.contieneItem(this))
            throw new ValidacionExcepcion("Un combo no puede contenerse asi mismo");
        productos.add(item);
        return this;
    }
    public boolean contieneItem(ItemMenu i) {
        return productos.contains(i);
    }

    public long precioLista() {
        return productos.stream().mapToLong(ItemMenu::precio).sum();
    }

    @Override
    public long precio() {
        return precioLista() * (100 - descuento) / 100;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String describir(String sangria) {
        StringBuilder string = new StringBuilder(sangria + " - " + nombre + "  $" + precio());
        for (ItemMenu item : productos) {
            string.append("\n").append(item.describir(sangria + "  "));
        }
        return string.toString();
    }

    public String id() {
        return id;
    }
    public List<ItemMenu> getProductos() {
        return Collections.unmodifiableList(productos);
    }
    public int descuento() {
        return descuento;
    }
}
