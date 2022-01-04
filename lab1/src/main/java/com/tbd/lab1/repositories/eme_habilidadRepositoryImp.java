package com.tbd.ejemplo1.repositories;


import java.util.List;

import com.tbd.ejemplo1.models.Eme_habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class eme_habilidadRepositoryImp implements eme_habilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Eme_habilidad> getAllEme_habilidad(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad")
            .executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Eme_habilidad getEme_habilidad(Long id) {
        String sql =
        "SELECT id_eme_habilidad, id_habilidad, id_emergencia "+
        "FROM eme_habilidad "+
        "WHERE id_habilidad = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_EME_HABILIDAD", "id_eme_habilidad")
            .executeAndFetchFirst(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Eme_habilidad createEme_habilidad(Eme_habilidad eme_habilidad) {
        String sql = 
        "INSERT INTO voluntario (id_habilidad, id_emergencia) "+
        "values (:id_h, :id_e)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_h", eme_habilidad.getId_habilidad())
                    .addParameter("id_e", eme_habilidad.getId_emergencia())
                    .executeUpdate()
                    .getKey();
            eme_habilidad.setId_eme_habilidad(insertedId);
            return eme_habilidad;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Eme_habilidad updateEme_habilidad(Eme_habilidad eme_habilidad){
        String sql =
        "UPDATE voluntario "+
        "set id_habilidad = :id_h, id_emergencia = :id_e "+
        "WHERE id_eme_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_h", eme_habilidad.getId_habilidad())
            .addParameter("id_e", eme_habilidad.getId_emergencia())
            .executeUpdate();
            return eme_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteEme_habilidad(Long id){
        String sql =
        "DELETE FROM eme_habilidad "+
        "WHERE id_eme_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
