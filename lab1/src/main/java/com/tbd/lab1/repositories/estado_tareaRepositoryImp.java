package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Estado_tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class estado_tareaRepositoryImp implements estado_tareaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Estado_tarea> getAllEstado_tareas(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from estado_tarea")
            .executeAndFetch(Estado_tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_tarea getEstado_tarea(Long id) {
        String sql =
        "SELECT id_estado_tarea, id_tarea , nombre "+
        "FROM estado_tarea "+
        "WHERE id_estado_tarea = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_ESTADO_TAREA", "id_estado_tarea")
            .executeAndFetchFirst(Estado_tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_tarea createEstado_tarea(Estado_tarea estado_tarea) {
        String sql = 
        "INSERT INTO estado_tarea (nombre) "+
        "values (:n)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("n", estado_tarea.getNombre())
                    .executeUpdate()
                    .getKey();
            estado_tarea.setId_estado_tarea(insertedId);
            return estado_tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Estado_tarea updateEstado_tarea(Estado_tarea estado_tarea){
        String sql =
        "UPDATE estado_tarea "+
        "set nombre = :n "+
        "WHERE id_estado_tarea = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("n", estado_tarea.getNombre())
            .executeUpdate();
            return estado_tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteEstado_tarea(Long id){
        String sql =
        "DELETE FROM estado_tarea "+
        "WHERE id_estado_tarea= :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
