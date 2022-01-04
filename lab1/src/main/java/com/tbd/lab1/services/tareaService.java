package com.tbd.lab1.services;

import com.tbd.lab1.models.Tarea;
import com.tbd.lab1.repositories.tareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
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
public class tareaService {

    private final tareaRepository tareaRepository;
    tareaService(tareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

    @GetMapping("/tareas")
    public List<Tarea> getAllTareas() {
        return tareaRepository.getAllTareas();
    }

    @GetMapping("/tareas/mostrar/{id}")
    public Tarea getTarea(@PathVariable(name = "id") Long id) {
        return tareaRepository.getTarea(id);
    }
    //Mappeo necesario para la 27
    @GetMapping("/tareas/voluntario/{id}")
    public List<Tarea> getVoluntarioTarea(@PathVariable(name = "id") Long id) {
        return tareaRepository.getVoluntarioTarea(id);
    }

    @PostMapping("/tareas/crear")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea Tarea){
        Tarea result = tareaRepository.createTarea(Tarea);
        return result;
    }

    @PutMapping("/tareas/update/{id}")
    @ResponseBody
    public Tarea updateTarea(@PathVariable(name = "id") Long id, @RequestBody Tarea Tarea) {

        Tarea tarea_seleccionado = new Tarea();
        Tarea tarea_actualizado = new Tarea();

        tarea_seleccionado = tareaRepository.getTarea(id);
        if (Tarea.getNombre_tarea() != null) tarea_seleccionado.setNombre_tarea(Tarea.getNombre_tarea());
        if (Tarea.getCapacidad() != null) tarea_seleccionado.setCapacidad(Tarea.getCapacidad());
        if (Tarea.getId_emergencia() != null) tarea_seleccionado.setId_emergencia(Tarea.getId_emergencia());
        if (Tarea.getId_estado_tarea() != null) tarea_seleccionado.setId_estado_tarea(Tarea.getId_estado_tarea());
        tarea_seleccionado.setEsVisible(Tarea.esVisible());

        tarea_actualizado = tareaRepository.updateTarea(tarea_seleccionado);

        return tarea_actualizado;
    }


    @GetMapping("/tareas/delete/{id}")
    public void deleteTarea(@PathVariable(name = "id") Long id){
        tareaRepository.deleteTarea(id);
    }

    /*@GetMapping("/tareas/completar/{id}")
    public void completeTarea(@PathVariable(name = "id") Long id){
        tareaRepository.completeTarea(id);
    }*/
}