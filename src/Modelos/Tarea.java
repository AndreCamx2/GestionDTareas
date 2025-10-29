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

    private static int contador = 1; // Genera ID automático
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
        this.usuario = usuario;
        this.prioridad = calcularPrioridad();
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

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
            

