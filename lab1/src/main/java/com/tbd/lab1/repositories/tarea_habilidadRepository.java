package com.tbd.lab1.repositories;

import java.util.List;

import com.tbd.lab1.models.Tarea_habilidad;

public interface tarea_habilidadRepository {
    public List<Tarea_habilidad> getAllTarea_habilidad();
    public Tarea_habilidad getTarea_habilidad(Long id);
    public Tarea_habilidad createTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public Tarea_habilidad updateTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public void deleteTarea_habilidad(Long id);
}
