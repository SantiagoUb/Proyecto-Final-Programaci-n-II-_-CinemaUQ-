package co.edu.uniquindio.poo.cinemauqproject.model;

public class TamanioGrande extends DecoradorItem {
     public TamanioGrande(DecoradorItem base) {
         super(base);
     }

    @Override
    public String nombre() {
        return super.nombre() + " Tamaño Grande";
    }

    @Override
    public long precio() {
        return super.precio() * 125 / 100;
    }
}
