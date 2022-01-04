package com.tbd.lab1.services;

import com.tbd.lab1.models.Emergencia;
import com.tbd.lab1.repositories.emergenciaRepository;

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
public class emergenciaService {
  
    private final emergenciaRepository emergenciaRepository;
    
    emergenciaService(emergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmergencias() {
        return emergenciaRepository.getAllEmergencias();
    }

    @GetMapping("/emergencias/mostrar/{id}")
    public Emergencia getEmergencia(@PathVariable(name = "id") Long id) {
        return emergenciaRepository.getEmergencia(id);
    }

    @PostMapping("/emergencias/create")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia result = emergenciaRepository.createEmergencia(emergencia);
        return result;
    }

    @PutMapping("/emergencias/update/{id}")
    @ResponseBody
    public Emergencia updateEmergencia(@PathVariable(name = "id") Long id, @RequestBody Emergencia emergencia) {

        Emergencia emergencia_seleccionada = new Emergencia();
        Emergencia emergencia_actualizada = new Emergencia();

        emergencia_seleccionada = emergenciaRepository.getEmergencia(id);
        if(emergencia.getRegion() != null) emergencia_seleccionada.setRegion(emergencia.getRegion());
        if(emergencia.getComuna() != null) emergencia_seleccionada.setComuna(emergencia.getComuna());
        if(emergencia.getCiudad() != null) emergencia_seleccionada.setCiudad(emergencia.getCiudad());
        if(emergencia.getId_emergencia() != null) emergencia_seleccionada.setId_institucion(emergencia.getId_institucion());

        emergencia_actualizada = emergenciaRepository.updateEmergencia(emergencia_seleccionada);

        return emergencia_actualizada;
    }

    @DeleteMapping("/emergencias/delete/{id}")
    public void deleteEmergencia(@PathVariable(name = "id") Long id){
        emergenciaRepository.deleteEmergencia(id);
    }
}
