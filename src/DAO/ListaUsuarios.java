/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author HP
 */

import Modelos.Usuario;
import java.io.*;
import java.util.LinkedList;

public class ListaUsuarios {

    private LinkedList<Usuario> lista;

    public ListaUsuarios() {
        lista = new LinkedList<>();
        cargar();
    }

    public LinkedList<Usuario> getLista() {
        return lista;
    }

    // Insertar un usuario y devolver si se guardó correctamente
    public boolean agregarUsuario(Usuario usuario) {
        lista.add(usuario);
        return guardar(); // devuelve true si guardado exitoso
    }

    // Buscar usuario por nombreUsuario
    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario u : lista) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    // Verificar existencia de usuario
    public boolean usuarioExiste(String nombreUsuario) {
        return buscarUsuario(nombreUsuario) != null;
    }

    // Guardar lista en archivo y devolver true si se guardó correctamente
    public boolean guardar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            salida.writeObject(lista);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
            return false;
        }
    }

    // Cargar lista desde archivo
    public void cargar() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            lista = (LinkedList<Usuario>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new LinkedList<>();
            System.out.println("Creando nuevo archivo de usuarios...");
        }
    }
}
