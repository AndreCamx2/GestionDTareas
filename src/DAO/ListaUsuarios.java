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
        cargar(); // 📌 Cargar usuarios existentes al iniciar
    }

    public LinkedList<Usuario> getLista() {
        return lista;
    }

    // ✅ Agregar usuario
    public boolean agregarUsuario(Usuario usuario) {
    if (usuarioExiste(usuario.getNombreUsuario())) {
        return false;
    }
    lista.add(usuario);
    guardar();
    return true;
}


    // ✅ Validar si existe para Login
    public boolean usuarioExiste(String nombreUsuario) {
        return lista.stream()
                .anyMatch(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
    }

    // ✅ Buscar usuario para Login
    public Usuario buscarUsuario(String nombreUsuario) {
        return lista.stream()
                .filter(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario))
                .findFirst()
                .orElse(null);
    }

    // ✅ Eliminar usuario si lo necesitas
    public boolean eliminarUsuario(String nombreUsuario) {
        boolean eliminado = lista.removeIf(u -> u.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
        if (eliminado) guardar();
        return eliminado;
    }

    // ✅ Guardar datos en archivo .dat
    public void guardar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ✅ Cargar datos al iniciar
    public void cargar() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
            lista = (LinkedList<Usuario>) entrada.readObject();
        } catch (Exception e) {
            // Si no existe el archivo aún, no pasa nada ✅
        }
    }
}
