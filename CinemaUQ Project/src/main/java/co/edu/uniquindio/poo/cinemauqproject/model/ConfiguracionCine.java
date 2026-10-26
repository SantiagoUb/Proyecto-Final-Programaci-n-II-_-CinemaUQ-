package co.edu.uniquindio.poo.cinemauqproject.model;

import java.time.Clock;
import java.time.LocalDateTime;

/** Patron SINGLETON configuracion y reloj unicos y compratidos */

public final class ConfiguracionCine {

    private static ConfiguracionCine INSTANCE = new ConfiguracionCine();
    /** Decision: se da 1 punto por cada $1.000 COP pagados con dinero. */
    public static final int COP_POR_PUNTO = 1000;
    /** Desicion: al redimir 1 punto equivale a $20 COP */
    public static final int VALOR_PUNTO_REDENCION = 20;
    public static final int VIGENCIA_PUNTOS_ANIOS = 1;
    private Clock reloj = Clock.systemDefaultZone();

    private ConfiguracionCine() {}

    public static ConfiguracionCine getInstancia() {
        return INSTANCE;
    }
    public LocalDateTime ahora(){
        return LocalDateTime.now(reloj);
    }

    public void fijarReloj(Clock c){
        this.reloj = c;
    }
}
