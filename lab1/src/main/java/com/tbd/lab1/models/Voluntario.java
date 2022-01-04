package com.tbd.ejemplo1.models;

public class Voluntario {
    private long id_voluntario;
    private String RUT;
    private String nombre_voluntario;
    private String region;
    private String comuna;
    private String ciudad;
    private boolean esVisible;

    public long getId_voluntario() {
        return this.id_voluntario;
    }

    public void setId_voluntario(long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getRUT() {
        return this.RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombre_voluntario() {
        return this.nombre_voluntario;
    }

    public void setNombre_voluntario(String nombre_voluntario) {
        this.nombre_voluntario = nombre_voluntario;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return this.comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean getEsVisible() {
        return this.esVisible;
    }

    public void setCiudad(Boolean esVisible) {
        this.esVisible = esVisible;
    }

}
