package com.tbd.lab1.repositories;

import java.util.List;

import com.tbd.lab1.models.Vol_habilidad;

public interface vol_habilidadRepository {
    public List<Vol_habilidad> getAllVol_habilidades();
    public Vol_habilidad getVol_habilidad(Long id);
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad);
    public Vol_habilidad updateVol_habilidad(Vol_habilidad vol_habilidad);
    public void deleteVol_habilidad(Long id);
}
