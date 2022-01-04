package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Eme_habilidad;
import java.util.*;

public interface eme_habilidadRepository {
    public List<Eme_habilidad> getAllEme_habilidad();
    public Eme_habilidad getEme_habilidad(Long id);
    public Eme_habilidad createEme_habilidad(Eme_habilidad eme_habilidad);
    public Eme_habilidad updateEme_habilidad(Eme_habilidad eme_habilidad);
    public void deleteEme_habilidad(Long id);
}
