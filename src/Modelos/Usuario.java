package Modelos;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;       // nombre real
    private String nombreUsuario; // usuario para login
    private String contrasena;   // contraseña

    public Usuario(String nombre, String nombreUsuario, String contrasena) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
}


