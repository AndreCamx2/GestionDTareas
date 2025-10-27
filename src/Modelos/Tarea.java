/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author HP
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int contador = 1; // Para generar ID automático
    private int id;
    private String nombre;
    private String asignatura;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String prioridad;
    private String usuario;

    public Tarea(String nombre, String asignatura, LocalDate fechaInicio, LocalDate fechaEntrega, String usuario) {
        this.id = contador++;
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.prioridad = calcularPrioridad();
        this.usuario = usuario;
    }

    // 🧠 Método para actualizar prioridad según el tiempo
    public void actualizarPrioridad() {
        this.prioridad = calcularPrioridad();
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getAsignatura() { return asignatura; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public String getPrioridad() { return prioridad; }
    public String getUsuario() { return usuario; }

    // Calcula prioridad automáticamente ⏳
    public String calcularPrioridad() {
        LocalDate hoy = LocalDate.now();
        long diasRestantes = ChronoUnit.DAYS.between(hoy, fechaEntrega);

        if (diasRestantes <= 0) {
            return "Caducada";
        } else if (diasRestantes <= 2) {
            return "Alta";
        } else if (diasRestantes <= 4) {
            return "Media";
        } else {
            return "Baja";
        }
    }
}
