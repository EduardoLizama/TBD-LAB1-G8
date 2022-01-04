package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Tarea;

public interface tareaRepository {
    public List<Tarea> getAllTareas();
    public Tarea getTarea(Long id);
    public List<Tarea> getVoluntarioTarea(Long id);
    public Tarea createTarea(Tarea tarea);
    public Tarea updateTarea(Tarea tarea);
    public void deleteTarea(Long id);
}
