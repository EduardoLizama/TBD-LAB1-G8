package com.tbd.lab1.services;

import com.tbd.lab1.models.Estado_tarea;
import com.tbd.lab1.repositories.estado_tareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin
@RestController
public class estado_tareaService {
    
    private final estado_tareaRepository estado_tareaRepository;
    estado_tareaService(estado_tareaRepository estado_tareaRepository){
        this.estado_tareaRepository = estado_tareaRepository;
    }

    @GetMapping("/estado_tareas")
    public List<Estado_tarea> getAllEstado_tareass() {
        return estado_tareaRepository.getAllEstado_tareas();
    }

    @GetMapping("/estado_tareas/mostrar/{id}")
    public Estado_tarea getEstado_tarea(@PathVariable(name = "id") Long id) {
        return estado_tareaRepository.getEstado_tarea(id);
    }

    @PostMapping("/estado_tarea/create")
    @ResponseBody
    public Estado_tarea createEstado_tarea(@RequestBody Estado_tarea Estado_tarea){
        Estado_tarea result = estado_tareaRepository.createEstado_tarea(Estado_tarea);
        return result;
    }

    @PutMapping("/estado_tareas/update/{id}")
    @ResponseBody
    public Estado_tarea updateEstado_tarea(@PathVariable(name = "id") Long id, @RequestBody Estado_tarea estado_tarea) {

        Estado_tarea Estado_tarea_seleccionado = new Estado_tarea();
        Estado_tarea Estado_tarea_actualizado = new Estado_tarea();

        Estado_tarea_seleccionado = estado_tareaRepository.getEstado_tarea(id);
        if(estado_tarea.getNombre() != null)Estado_tarea_seleccionado.setNombre(estado_tarea.getNombre());

        Estado_tarea_actualizado = estado_tareaRepository.updateEstado_tarea(Estado_tarea_seleccionado);

        return Estado_tarea_actualizado;
    }


    @DeleteMapping("/estado_tareas/delete/{id}")
    public void deleteEstado_tarea(@PathVariable(name = "id") Long id){
        estado_tareaRepository.deleteEstado_tarea(id);
    }
    
}
