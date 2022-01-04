package com.tbd.ejemplo1.services;

import com.tbd.ejemplo1.models.Vol_habilidad;
import com.tbd.ejemplo1.repositories.vol_habilidadRepository;

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
public class vol_habilidadService {
    
    private final vol_habilidadRepository vol_habilidadRepository;
    vol_habilidadService(vol_habilidadRepository vol_habilidadRepository){
        this.vol_habilidadRepository = vol_habilidadRepository;
    }

    @GetMapping("/vol_habilidades")
    public List<Vol_habilidad> getAllVol_habilidad() {
        return vol_habilidadRepository.getAllVol_habilidades();
    }

    @GetMapping("/vol_habilidades/mostrar/{id}")
    public Vol_habilidad getVol_habilidad(@PathVariable(name = "id") Long id) {
        return vol_habilidadRepository.getVol_habilidad(id);
    }

    @PostMapping("/vol_habilidades/crear")
    @ResponseBody
    public Vol_habilidad createVol_habilidad(@RequestBody Vol_habilidad Vol_habilidad){
        Vol_habilidad result = vol_habilidadRepository.createVol_habilidad(Vol_habilidad);
        return result;
    }

    @PutMapping("/vol_habilidades/update/{id}")
    @ResponseBody
    public Vol_habilidad updateVol_habilidad(@PathVariable(name = "id") Long id, @RequestBody Vol_habilidad Vol_habilidad) {

        Vol_habilidad vol_habilidad_seleccionado = new Vol_habilidad();
        Vol_habilidad vol_habilidad_actualizado = new Vol_habilidad();

        vol_habilidad_seleccionado = vol_habilidadRepository.getVol_habilidad(id);
        if (Vol_habilidad.getId_habilidad() != null) vol_habilidad_seleccionado.setId_habilidad(Vol_habilidad.getId_habilidad());
        if (Vol_habilidad.getId_vol_habilidad() != null) vol_habilidad_seleccionado.setId_vol_habilidad(Vol_habilidad.getId_vol_habilidad());

        vol_habilidad_actualizado = vol_habilidadRepository.updateVol_habilidad(vol_habilidad_seleccionado);

        return vol_habilidad_actualizado;
    }

    @DeleteMapping("/vol_habilidades/delete/{id}")
    public void deletevol_habilidad(@PathVariable(name = "id") Long id){
        vol_habilidadRepository.deleteVol_habilidad(id);
    }
}
