package com.tbd.ejemplo1.repositories;

import com.tbd.ejemplo1.models.Emergencia;
import java.util.*;

public interface emergenciaRepository {
    public List<Emergencia> getAllEmergencias();
    public Emergencia getEmergencia(Long id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public Emergencia updateEmergencia(Emergencia emergencia);
    public void deleteEmergencia(Long id);
}
