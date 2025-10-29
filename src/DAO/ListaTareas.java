package DAO;

import Modelos.Tarea;
import java.io.*;
import java.util.LinkedList;

public class ListaTareas {

    private LinkedList<Tarea> lista;

    public ListaTareas() {
        lista = new LinkedList<>();
        try {
            cargar();
        } catch (Exception e) {
            System.out.println("Creando nuevo archivo de tareas...");
        }
    }

    public LinkedList<Tarea> getLista() {
        return lista;
    }

    public void listarTareas() {
        for (Tarea t : lista) {
            System.out.println(t.getId() + " - " + t.getNombre());
        }
    }

    public void insertarTarea(Tarea tarea) {
        lista.add(tarea);
        guardar();
    }

    public boolean eliminarTarea(int id) {
        boolean estado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                guardar();
                estado = true;
                break;
            }
        }
        return estado;
    }

    public void guardar() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("archivoTareas.dat"))) {
            salida.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
    }

    public void cargar() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivoTareas.dat"))) {
            lista = (LinkedList<Tarea>) entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            lista = new LinkedList<>();
        }
    }
}
