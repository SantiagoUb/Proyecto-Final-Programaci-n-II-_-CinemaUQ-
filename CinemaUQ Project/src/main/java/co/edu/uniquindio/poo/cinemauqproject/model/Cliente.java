package co.edu.uniquindio.poo.cinemauqproject.model;

public class Cliente extends Usuario {
    public Cliente(String nombre, String email, String password) {
        super(Ids.nuevo("CLI"), nombre, email, password, Rol.CLIENTE);
    }
}
