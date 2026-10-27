package co.edu.uniquindio.poo.cinemauqproject.model;

public record Asiento(char fila, int numero) {
    public String codigo(){
        return "" + fila + numero;
    }

    @Override
    public String toString() {
        return codigo();
    }
}
