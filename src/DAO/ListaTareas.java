/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author HP
 */

import Modelos.Tarea;
import Modelos.Usuario;
import java.io.*;
import java.util.LinkedList;

public class ListaTareas {

    private LinkedList<Tarea> lista;

    public ListaTareas() {
        lista = new LinkedList<>();
        cargar(); // Siempre intentar cargar archivo al iniciar
    }

    public LinkedList<Tarea> getLista() {
        return lista;
    }

    public void insertarTarea(Tarea tarea) {
        lista.add(tarea);
        guardar();
    }

    public boolean eliminarTarea(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                guardar();
                return true;
            }
        }
        return false;
    }

    public void guardar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("archivoTareas.dat"))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cargar() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivoTareas.dat"))) {
            lista = (LinkedList<Tarea>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new LinkedList<>();
            System.out.println("Creando nuevo archivo de tareas...");
        }
    }
public LinkedList<Tarea> obtenerTareasUsuario(String nombreUsuario) {
    LinkedList<Tarea> filtradas = new LinkedList<>();

    for (Tarea t : lista) {
        if (t.getUsuario() != null &&
            t.getUsuario().equalsIgnoreCase(nombreUsuario)) {

            filtradas.add(t);
        }
    }

    return filtradas;
}




}

