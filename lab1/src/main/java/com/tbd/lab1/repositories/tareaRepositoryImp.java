package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class tareaRepositoryImp implements tareaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> getAllTareas(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea where esVisible ='true'")
            .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea getTarea(Long id) {
        String sql =
        "SELECT id_tarea, id_emergencia , nombre_tarea, capacidad, id_estado_tarea "+
        "FROM tarea "+
        "WHERE id_tarea = :id and esVisible = 'true'";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_TAREA", "id_tarea")
            .executeAndFetchFirst(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //@Override
    public List<Tarea> getVoluntarioTarea(Long idVoluntario) {
        String sql =
        "SELECT t.id_tarea, id_emergencia , nombre_tarea, capacidad, id_estado_tarea "+
        "FROM tarea as t, ranking, voluntario "+
        "WHERE voluntario.id_voluntario = :id and voluntario.id_voluntario = ranking.id_voluntario and ranking.id_tarea=t.id_tarea and t.esVisible = 'true' and ranking.estadotarea != 'Completada' and ranking.estadotarea != 'Cancelada' ";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", idVoluntario)
            .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        String sql = 
        "INSERT INTO tarea (id_emergencia, nombre_tarea, capacidad, id_estado_tarea, esVisible) "+
        "values (:id_e, :n, :c, :id_est, :vis)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_e", tarea.getId_emergencia())
                    .addParameter("n", tarea.getNombre_tarea())
                    .addParameter("c", tarea.getCapacidad())
                    .addParameter("id_est", tarea.getId_estado_tarea())
                    .addParameter("vis", tarea.esVisible())
                    .executeUpdate()
                    .getKey();
            tarea.setId_tarea(insertedId);
            return tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Tarea updateTarea(Tarea tarea){
        String sql =
        "UPDATE tarea "+
        "set id_emergencia= :id_e, nombre_tarea = :n, capacidad = :c, id_estado_tarea=:id_est, esVisible=:vis "+
        "WHERE id_tarea = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_e", tarea.getId_emergencia())
            .addParameter("n", tarea.getNombre_tarea())
            .addParameter("c", tarea.getCapacidad())
            .addParameter("id_est", tarea.getId_estado_tarea())
            .addParameter("vis", tarea.esVisible())
            .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteTarea(Long id){
        String sql =
        "UPDATE tarea "+
        "set esVisible='false' "+
        "WHERE id_tarea= :id ";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
