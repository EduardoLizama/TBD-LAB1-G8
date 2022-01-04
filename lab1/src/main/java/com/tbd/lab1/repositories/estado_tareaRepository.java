package com.tbd.ejemplo1.repositories;

import java.util.*;
import com.tbd.ejemplo1.models.Estado_tarea;

public interface estado_tareaRepository {
    public List<Estado_tarea> getAllEstado_tareas();
    public Estado_tarea getEstado_tarea(Long id);
    public Estado_tarea createEstado_tarea(Estado_tarea estado_tarea);
    public Estado_tarea updateEstado_tarea(Estado_tarea estado_tarea);
    public void deleteEstado_tarea(Long id);
}
