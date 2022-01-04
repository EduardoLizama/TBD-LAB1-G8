package com.tbd.ejemplo1.models;

public class Tarea_habilidad {
    private Long id_tarea_habilidad;
    private Long id_habilidad;
    private Long id_tarea;

    public Long getId_tarea_habilidad() {
        return this.id_tarea_habilidad;
    }

    public void setId_tarea_habilidad(Long id_tarea_habilidad) {
        this.id_tarea_habilidad = id_tarea_habilidad;
    }

    public Long getId_habilidad() {
        return this.id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public Long getId_tarea() {
        return this.id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

}
