package co.edu.uniquindio.poo.cinemauqproject.model;

import java.util.UUID;

/** Generador de identoficadores unicos para usuarios, entradas, compras, etc... */

public final class Ids {
    public static String nuevo(String prefijo){
        return prefijo + "-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }
}
