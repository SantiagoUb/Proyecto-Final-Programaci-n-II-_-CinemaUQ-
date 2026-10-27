package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.AsientoNoDisponibleExcepcion;
import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.FuncionNoDisponibleExcepcion;
import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Funcion {
    private final String id;
    private Pelicula pelicula;
    private final Sala sala;
    private final LocalDateTime inicio;
    private final long precioEntrada;
    private boolean cancelada;
    private Set<Asiento> ocupados = new HashSet<>();

    public Funcion(Pelicula pelicula, Sala sala, LocalDateTime inicio, long precioEntrada) {
        if(pelicula == null || sala == null || inicio == null || precioEntrada <= 0)
            throw new ValidacionExcepcion("Para la funcion la paelicula, las sala, la fecha y el precio son obligatorias");
        this.id = Ids.nuevo("FUN");
        this.pelicula = pelicula;
        this.sala = sala;
        this.inicio = inicio;
        this.precioEntrada = precioEntrada;
    }

    public synchronized void reservar(Collection<Asiento> pedidos) {
        if(cancelada) throw new FuncionNoDisponibleExcepcion("La funcion fue cancelada");
        if(!inicio.isAfter(ConfiguracionCine.getInstancia().ahora())) throw new FuncionNoDisponibleExcepcion("La funcion ya inicio");
        for(Asiento a : pedidos){
            if(!sala.asientos().contains(a)) throw new ValidacionExcepcion("El asiento " + a + " no esta en la sala");
            if(ocupados.contains(a)) throw new AsientoNoDisponibleExcepcion("El asiento " + a + " ya se vendio para esta funcion");
        }
        ocupados.addAll(pedidos);
    }

    public synchronized void liberar(Collection<Asiento> asientos) {
        ocupados.removeAll(asientos);
    }
    public synchronized boolean estaOcupado(Asiento asiento) {
        return ocupados.contains(asiento);
    }
    public synchronized int ocupados(){
        return ocupados.size();
    }
    public synchronized void reasignarPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    public synchronized void cancelar() {
        cancelada = true;
    }

    public boolean cancelada(){
        return cancelada;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public Sala getSala() {
        return sala;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public long getPrecioEntrada() {
        return precioEntrada;
    }
    public String getId() {
        return id;
    }
}
