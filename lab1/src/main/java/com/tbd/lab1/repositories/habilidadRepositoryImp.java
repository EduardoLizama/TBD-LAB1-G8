package com.tbd.lab1.repositories;

import java.util.List;


import com.tbd.lab1.models.Habilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class habilidadRepositoryImp implements habilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> getAllHabilidades(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad")
            .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad getHabilidad(Long id) {
        String sql =
        "SELECT id_habilidad, nombre_habilidad , descripcion "+
        "FROM habilidad "+
        "WHERE id_habilidad = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_HABILIDAD", "id_habilidad")
            .executeAndFetchFirst(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        String sql = 
        "INSERT INTO habilidad (nombre_habilidad, descripcion) "+
        "values (:nh, :d)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("nh", habilidad.getNombre_habilidad())
                    .addParameter("d", habilidad.getDescripcion())
                    .executeUpdate()
                    .getKey();
            habilidad.setId_habilidad(insertedId);
            return habilidad;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Habilidad updateHabilidad(Habilidad habilidad){
        String sql =
        "UPDATE habilidad "+
        "set nombre_habilidad = :nh, descripcion = :d "+
        "WHERE id_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("nh", habilidad.getNombre_habilidad())
            .addParameter("d", habilidad.getDescripcion())
            .executeUpdate();
            return habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteHabilidad(Long id){
        String sql =
        "DELETE FROM Habilidad "+
        "WHERE id_Habilidad= :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
