package com.tbd.lab1.models;

public class Tarea {
    private Long id_tarea;
    private String nombre_tarea;
    private Integer capacidad;
    private Long id_emergencia;
    private Long id_estado_tarea;
    private boolean esVisible;

    public Long getId_estado_tarea() {
        return this.id_estado_tarea;
    }

    public void setId_estado_tarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }


    public boolean esVisible() {
        return this.esVisible;
    }

    public void setEsVisible(boolean esVisible) {
        this.esVisible = esVisible;
    }

    public Long getId_tarea() {
        return this.id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre_tarea() {
        return this.nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public Integer getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Long getId_emergencia() {
        return this.id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

}
