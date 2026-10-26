package co.edu.uniquindio.poo.cinemauqproject.model;

import co.edu.uniquindio.poo.cinemauqproject.model.excepcion.ValidacionExcepcion;

public abstract class Usuario {
    private final String id, nombre, email, password;
    private final Rol rol;

    protected Usuario(String id, String nombre, String email, String password, Rol rol) {
        if(nombre == null || nombre.isBlank() || email == null || email.contains("@"))
            throw new ValidacionExcepcion("El nombre y el email son obligatorios");
        if(password == null || password.length() < 6)
            throw new ValidacionExcepcion("La contraseña debe tener minimo 6 caracteres");
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public boolean autenticar(String email, String password) {
        return this.email.equalsIgnoreCase(email) && this.password.equals(password);
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public Rol getRol() {
        return rol;
    }
}
