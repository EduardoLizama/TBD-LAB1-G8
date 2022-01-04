package com.tbd.ejemplo1.services;

import com.tbd.ejemplo1.models.Voluntario;
import com.tbd.ejemplo1.repositories.voluntarioRepository;

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
public class VoluntarioService {

    private final voluntarioRepository voluntarioRepository;
    VoluntarioService(voluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @GetMapping("/voluntarios")
    public List<Voluntario> getAllVoluntarios() {
        return voluntarioRepository.getAllVoluntarios();
    }

    @GetMapping("/voluntarios/mostrar/{id}")
    public Voluntario getVoluntario(@PathVariable(name = "id") Long id) {
        return voluntarioRepository.getVoluntario(id);
    }

    @GetMapping("/voluntarios/count")
    public String countVoluntarios(){
        int total = voluntarioRepository.countVoluntarios();
        return String.format("Existen %s voluntarios!!", total);
    }

    @PostMapping("/voluntarios/create")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
        Voluntario result = voluntarioRepository.createVoluntario(voluntario);
        return result;
    }

    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public Voluntario updateVoluntario(@PathVariable(name = "id") Long id, @RequestBody Voluntario voluntario) {

        Voluntario voluntario_seleccionado = new Voluntario();
        Voluntario voluntario_actualizado = new Voluntario();

        voluntario_seleccionado = voluntarioRepository.getVoluntario(id);
        if(voluntario.getRUT() != null) voluntario_seleccionado.setRUT(voluntario.getRUT());
        if(voluntario.getNombre_voluntario() != null) voluntario_seleccionado.setNombre_voluntario(voluntario.getNombre_voluntario());
        if(voluntario.getRegion() != null) voluntario_seleccionado.setRegion(voluntario.getRegion());
        if(voluntario.getComuna() != null) voluntario_seleccionado.setComuna(voluntario.getComuna());
        if(voluntario.getCiudad() != null) voluntario_seleccionado.setCiudad(voluntario.getCiudad());

        voluntario_actualizado = voluntarioRepository.updateVoluntario(voluntario_seleccionado);

        return voluntario_actualizado;
    }


    @DeleteMapping("/voluntarios/delete/{id}")
    public void deleteVoluntario(@PathVariable(name = "id") Long id){
        voluntarioRepository.deleteVoluntario(id);
    }
}