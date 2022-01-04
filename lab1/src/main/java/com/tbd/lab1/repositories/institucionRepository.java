package com.tbd.ejemplo1.repositories;

import java.util.*;
import com.tbd.ejemplo1.models.Institucion;

public interface institucionRepository {
    public List<Institucion> getAllInstituciones();
    public Institucion getInstitucion(Long id);
    public Institucion createInstitucion(Institucion institucion);
    public Institucion updateInstitucion(Institucion institucion);
    public void deleteInstitucion(Long id);
}
