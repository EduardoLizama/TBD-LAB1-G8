package com.tbd.ejemplo1.repositories;

import java.util.List;
import com.tbd.ejemplo1.models.Tarea_habilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class tarea_habilidadRepositoryImp implements tarea_habilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea_habilidad> getAllTarea_habilidad(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
            .executeAndFetch(Tarea_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_habilidad getTarea_habilidad(Long id) {
        String sql =
        "SELECT id_tarea_habilidad, id_tarea , id_habilidad "+
        "FROM tarea_habilidad "+
        "WHERE id_tarea_habilidad = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_TAREA_HABILIDAD", "id_tarea_habilidad")
            .executeAndFetchFirst(Tarea_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_habilidad createTarea_habilidad(Tarea_habilidad tarea_habilidad) {
        String sql = 
        "INSERT INTO tarea_habilidad (id_tarea, id_habilidad) "+
        "values (:id_t, :id_h)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_t", tarea_habilidad.getId_tarea())
                    .addParameter("id_h", tarea_habilidad.getId_habilidad())
                    .executeUpdate()
                    .getKey();
            tarea_habilidad.setId_tarea_habilidad(insertedId);
            return tarea_habilidad;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Tarea_habilidad updateTarea_habilidad(Tarea_habilidad tarea_habilidad){
        String sql =
        "UPDATE tarea_habilidad "+
        "set id_tarea = :id_t, id_habilidad = :id_h "+
        "WHERE id_tarea_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_t", tarea_habilidad.getId_tarea())
            .addParameter("id_h", tarea_habilidad.getId_habilidad())
            .executeUpdate();
            return tarea_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteTarea_habilidad(Long id){
        String sql =
        "DELETE FROM tarea_habilidad "+
        "WHERE id_tarea_habilidad= :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
