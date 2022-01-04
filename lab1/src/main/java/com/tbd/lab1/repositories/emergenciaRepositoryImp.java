package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class emergenciaRepositoryImp implements emergenciaRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia> getAllEmergencias(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from emergencia")
            .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergencia(Long id) {
        String sql =
        "SELECT id_emergencia, id_institucion ,region, comuna, ciudad "+
        "FROM emergencia "+
        "WHERE id_emergencia = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_EMERGENCIA", "id_emergencia")
            .executeAndFetchFirst(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        String sql = 
        "INSERT INTO emergencia (id_institucion, region, comuna, ciudad) "+
        "values (:id_i, :r, :co, :ci)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_i", emergencia.getId_institucion())
                    .addParameter("r", emergencia.getRegion())
                    .addParameter("co", emergencia.getComuna())
                    .addParameter("ce", emergencia.getCiudad())
                    .executeUpdate()
                    .getKey();
            emergencia.setId_emergencia(insertedId);
            return emergencia;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Emergencia updateEmergencia(Emergencia emergencia){
        String sql =
        "UPDATE emergencia "+
        "set id_institucion = :id_i, region = :r, comuna = :co, ciudad = :ci "+
        "WHERE id_emergencia = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_i", emergencia.getId_institucion())
            .addParameter("r", emergencia.getRegion())
            .addParameter("co", emergencia.getComuna())
            .addParameter("ce", emergencia.getCiudad())
            .executeUpdate();
            return emergencia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteEmergencia(Long id){
        String sql =
        "DELETE FROM emergencia "+
        "WHERE id_emergencia= :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
