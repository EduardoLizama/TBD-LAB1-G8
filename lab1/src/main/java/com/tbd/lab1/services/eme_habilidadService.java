package com.tbd.ejemplo1.services;

import com.tbd.ejemplo1.models.Eme_habilidad;
import com.tbd.ejemplo1.repositories.eme_habilidadRepository;

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
public class eme_habilidadService {
    private final eme_habilidadRepository eme_habilidadRepository;
    eme_habilidadService(eme_habilidadRepository eme_habilidadRepository){
        this.eme_habilidadRepository = eme_habilidadRepository;
    }

    @GetMapping("/eme_habilidad")
    public List<Eme_habilidad> getAllEme_habilidads() {
        return eme_habilidadRepository.getAllEme_habilidad();
    }

    @GetMapping("/eme_habilidad/mostrar/{id}")
    public Eme_habilidad getEme_habilidad(@PathVariable(name = "id") Long id) {
        return eme_habilidadRepository.getEme_habilidad(id);
    }

    @PostMapping("/eme_habilidad/create")
    @ResponseBody
    public Eme_habilidad createEme_habilidad(@RequestBody Eme_habilidad eme_habilidad){
        Eme_habilidad result = eme_habilidadRepository.createEme_habilidad(eme_habilidad);
        return result;
    }

    @PutMapping("/eme_habilidad/update/{id}")
    @ResponseBody
    public Eme_habilidad updateEme_habilidad(@PathVariable(name = "id") Long id, @RequestBody Eme_habilidad eme_habilidad) {

        Eme_habilidad he_seleccionado = new Eme_habilidad();
        Eme_habilidad he_actualizado = new Eme_habilidad();

        he_seleccionado = eme_habilidadRepository.getEme_habilidad(id);
        if(eme_habilidad.getId_emergencia() != null) he_seleccionado.setId_emergencia(eme_habilidad.getId_emergencia());
        if(eme_habilidad.getId_habilidad() != null) he_seleccionado.setId_habilidad(eme_habilidad.getId_habilidad());

        he_actualizado = eme_habilidadRepository.updateEme_habilidad(he_seleccionado);

        return he_actualizado;
    }

    @DeleteMapping("/eme_habilidad/delete/{id}")
    public void deleteEme_habilidad(@PathVariable(name = "id") Long id){
        eme_habilidadRepository.deleteEme_habilidad(id);
    }
}
