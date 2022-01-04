package com.tbd.ejemplo1.services;

import com.tbd.ejemplo1.models.Habilidad;
import com.tbd.ejemplo1.repositories.habilidadRepository;

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
public class habilidadService {
    private final habilidadRepository habilidadRepository;
    habilidadService(habilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping("/habilidades")
    public List<Habilidad> getAllHabilidades() {
        return habilidadRepository.getAllHabilidades();
    }

    @GetMapping("/habilidades/mostrar/{id}")
    public Habilidad getHabilidad(@PathVariable(name = "id") Long id) {
        return habilidadRepository.getHabilidad(id);
    }

    @PostMapping("/habilidades/create")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad result = habilidadRepository.createHabilidad(habilidad);
        return result;
    }

    @PutMapping("/habilidades/update/{id}")
    @ResponseBody
    public Habilidad updateHabilidad(@PathVariable(name = "id") Long id, @RequestBody Habilidad habilidad) {

        Habilidad habilidad_seleccionado = new Habilidad();
        Habilidad habilidad_actualizado = new Habilidad();

        habilidad_seleccionado = habilidadRepository.getHabilidad(id);
        if(habilidad.getId_habilidad() != null) habilidad_seleccionado.setId_habilidad(habilidad.getId_habilidad());
        if(habilidad.getNombre_habilidad() != null) habilidad_seleccionado.setNombre_habilidad(habilidad.getNombre_habilidad());
        if(habilidad.getDescripcion() != null) habilidad_seleccionado.setDescripcion(habilidad.getDescripcion());

        habilidad_actualizado = habilidadRepository.updateHabilidad(habilidad_seleccionado);

        return habilidad_actualizado;
    }

    @DeleteMapping("/habilidades/delete/{id}")
    public void deleteHabilidad(@PathVariable(name = "id") Long id){
        habilidadRepository.deleteHabilidad(id);
    }
}
