package com.tbd.ejemplo1.models;

public class Emergencia {
    private Long id_emergencia;
    private String region;
    private String comuna;
    private String ciudad;
    private Long id_institucion;

    public Long getId_emergencia() {
        return this.id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
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

    public Long getId_institucion() {
        return this.id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

}
