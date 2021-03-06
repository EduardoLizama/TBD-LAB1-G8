package com.tbd.lab1.repositories;

import com.tbd.lab1.models.Voluntario;
import java.util.*;

public interface voluntarioRepository {
    public List<Voluntario> getAllVoluntarios();
    public int countVoluntarios();
    public Voluntario getVoluntario(Long id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public Voluntario updateVoluntario(Voluntario voluntario);
    public void deleteVoluntario(Long id);
}
