package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Vol_habilidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class vol_habilidadRepositoryImp implements vol_habilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Vol_habilidad> getAllVol_habilidades(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad")
            .executeAndFetch(Vol_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Vol_habilidad getVol_habilidad(Long id) {
        String sql =
        "SELECT id_vol_habilidad, id_voluntario , id_habilidad "+
        "FROM vol_habilidad "+
        "WHERE id_vol_habilidad = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_VOL_HABILIDAD", "id_VOL_HABILIDAD")
            .executeAndFetchFirst(Vol_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Vol_habilidad createVol_habilidad(Vol_habilidad vol_habilidad) {
        String sql = 
        "INSERT INTO vol_habilidad (id_voluntario, id_habilidad) "+
        "values (:id_v, :id_h)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_v", vol_habilidad.getId_voluntario())
                    .addParameter("id_h", vol_habilidad.getId_habilidad())
                    .executeUpdate()
                    .getKey();
            vol_habilidad.setId_vol_habilidad(insertedId);
            return vol_habilidad;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Vol_habilidad updateVol_habilidad(Vol_habilidad vol_habilidad){
        String sql =
        "UPDATE vol_habilidad "+
        "set id_voluntario= :id_v, id_habilidad = :id_h "+
        "WHERE id_vol_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_v", vol_habilidad.getId_voluntario())
            .addParameter("id_h", vol_habilidad.getId_habilidad())
            .executeUpdate();
            return vol_habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteVol_habilidad(Long id){
        String sql =
        "DELETE FROM vol_habilidad "+
        "WHERE id_vol_habilidad = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
