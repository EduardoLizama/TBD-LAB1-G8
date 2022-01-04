package com.tbd.lab1.services;

import com.tbd.lab1.models.Institucion;
import com.tbd.lab1.repositories.institucionRepository;

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
public class institucionService {

    private final institucionRepository institucionRepository;
    institucionService(institucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/instituciones")
    public List<Institucion> getAllInstituciones() {
        return institucionRepository.getAllInstituciones();
    }

    @GetMapping("/instituciones/mostrar/{id}")
    public Institucion getInstitucion(@PathVariable(name = "id") Long id) {
        return institucionRepository.getInstitucion(id);
    }

    @PostMapping("/instituciones/create")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.createInstitucion(institucion);
        return result;
    }

    @PutMapping("/instituciones/update/{id}")
    @ResponseBody
    public Institucion updateInstitucion(@PathVariable(name = "id") Long id, @RequestBody Institucion institucion) {

        Institucion institucion_seleccionada = new Institucion();
        Institucion institucion_actualizada = new Institucion();

        institucion_seleccionada = institucionRepository.getInstitucion(id);
        if(institucion.getNombre_institucion() != null) institucion_seleccionada.setNombre_institucion(institucion.getNombre_institucion());
        

        institucion_actualizada = institucionRepository.updateInstitucion(institucion_seleccionada);

        return institucion_actualizada;
    }


    @DeleteMapping("/instituciones/delete/{id}")
    public void deleteInstitucion(@PathVariable(name = "id") Long id){
        institucionRepository.deleteInstitucion(id);
    }
}
