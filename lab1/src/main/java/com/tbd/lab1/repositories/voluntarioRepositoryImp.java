package com.tbd.ejemplo1.repositories;


import com.tbd.ejemplo1.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.*;

@Repository
public class voluntarioRepositoryImp implements voluntarioRepository{
    @Autowired
    private Sql2o sql2o;


    @Override
    public int countVoluntarios() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Voluntario> getAllVoluntarios() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario where esVisible='true'")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntario(Long id) {
        String sql =
        "SELECT id_voluntario, rut, nombre_voluntario, region, comuna, ciudad, esVisible "+
        "FROM voluntario "+
        "WHERE id_voluntario =  :id and esVisible='true' ";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_VOLUNTARIO", "id_voluntario")
            .executeAndFetchFirst(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery("INSERT INTO voluntario (rut, nombre_voluntario, region, comuna, ciudad, esVisible) " + 
            "values (:rut, :nombre_voluntario, :region, :comuna, :ciudad, :esVisible)", true)
                    .addParameter("rut", voluntario.getRUT())
                    .addParameter("nombre_voluntario", voluntario.getNombre_voluntario())
                    .addParameter("region", voluntario.getRegion())
                    .addParameter("comuna", voluntario.getComuna())
                    .addParameter("ciudad", voluntario.getCiudad())
                    .addParameter("esVisible", voluntario.getEsVisible())
                    .executeUpdate()
                    .getKey();
            voluntario.setId_voluntario(insertedId);
            return voluntario;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Voluntario updateVoluntario(Voluntario voluntario){
        String sql =
        "UPDATE voluntario "+
        "set rut = :nRut, nombre_voluntario = :nNombre, region = :nRegion, comuna = :nComuna, ciudad = :nCiudad, esVisible = :nEsVisible "+
        "WHERE id_voluntario = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", voluntario.getId_voluntario())
            .addParameter("nRut", voluntario.getRUT())
            .addParameter("nNombre", voluntario.getNombre_voluntario())
            .addParameter("nRegion", voluntario.getRegion())
            .addParameter("nComuna", voluntario.getComuna())
            .addParameter("nCiudad", voluntario.getCiudad())
            .addParameter("nEsVisible", voluntario.getEsVisible())
            .executeUpdate();
            return voluntario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteVoluntario(Long id){
        String sql =
        "UPDATE voluntario "+
        "set esVisible='false' "+
        "WHERE id_voluntario = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
