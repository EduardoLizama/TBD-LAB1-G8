package com.tbd.lab1.services;

import com.tbd.lab1.models.Tarea_habilidad;
import com.tbd.lab1.repositories.tarea_habilidadRepository;

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
public class tarea_habilidadService {
    
    private final tarea_habilidadRepository tarea_habilidadRepository;
    tarea_habilidadService(tarea_habilidadRepository tarea_habilidadRepository){
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    @GetMapping("/tarea_habilidad")
    public List<Tarea_habilidad> getAllTarea_habilidad() {
        return tarea_habilidadRepository.getAllTarea_habilidad();
    }

    @GetMapping("/tarea_habilidad/mostrar/{id}")
    public Tarea_habilidad getTarea_habilidad(@PathVariable(name = "id") Long id) {
        return tarea_habilidadRepository.getTarea_habilidad(id);
    }

    @PostMapping("/tarea_habilidad/create")
    @ResponseBody
    public Tarea_habilidad createTarea_habilidad(@RequestBody Tarea_habilidad tarea_habilidad){
        Tarea_habilidad result = tarea_habilidadRepository.createTarea_habilidad(tarea_habilidad);
        return result;
    }

    @PutMapping("/tarea_habilidad/update/{id}")
    @ResponseBody
    public Tarea_habilidad updateTarea_habilidad(@PathVariable(name = "id") Long id, @RequestBody Tarea_habilidad tarea_habilidad) {

        Tarea_habilidad tarea_habilidad_seleccionada = new Tarea_habilidad();
        Tarea_habilidad tarea_habilidad_actualizada = new Tarea_habilidad();

        tarea_habilidad_seleccionada = tarea_habilidadRepository.getTarea_habilidad(id);
        if(tarea_habilidad.getId_habilidad() != null) tarea_habilidad_seleccionada.setId_habilidad(tarea_habilidad.getId_habilidad());
        if(tarea_habilidad.getId_tarea() != null) tarea_habilidad_seleccionada.setId_tarea(tarea_habilidad.getId_tarea());

        tarea_habilidad_actualizada = tarea_habilidadRepository.updateTarea_habilidad(tarea_habilidad_seleccionada);

        return tarea_habilidad_actualizada;
    }

    @DeleteMapping("/tarea_habilidad/delete/{id}")
    public void deleteTarea_habilidad(@PathVariable(name = "id") Long id){
        tarea_habilidadRepository.deleteTarea_habilidad(id);
    }
}
