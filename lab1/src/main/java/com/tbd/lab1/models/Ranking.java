package com.tbd.ejemplo1.models;

public class Ranking {
    private Long id_ranking;
    private String estadotarea;
    private Long id_voluntario;
    private Long id_tarea;

    public Long getId_ranking() {
        return this.id_ranking;
    }

    public void setId_ranking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public String getEstadotarea() {
        return this.estadotarea;
    }

    public void setEstadotarea(String Estadotarea) {
        this.estadotarea = Estadotarea;
    }

    public Long getId_voluntario() {
        return this.id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Long getId_tarea() {
        return this.id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

}
