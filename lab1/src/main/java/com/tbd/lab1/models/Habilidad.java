package com.tbd.lab1.models;

public class Habilidad {
    private Long id_habilidad;
    private String nombre_habilidad;
    private String descripcion;

    public Long getId_habilidad() {
        return this.id_habilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getNombre_habilidad() {
        return this.nombre_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad) {
        this.nombre_habilidad = nombre_habilidad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
