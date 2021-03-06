package com.tbd.lab1.repositories;

import java.util.*;
import com.tbd.lab1.models.Habilidad;

public interface habilidadRepository {
    public List<Habilidad> getAllHabilidades();
    public Habilidad getHabilidad(Long id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public Habilidad updateHabilidad(Habilidad habilidad);
    public void deleteHabilidad(Long id);
}
