package com.tbd.ejemplo1.repositories;

import java.util.List;

import com.tbd.ejemplo1.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class institucionRepositoryImp implements institucionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institucion> getAllInstituciones(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from institucion")
            .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institucion getInstitucion(Long id) {
        String sql =
        "SELECT id_institucion, nombre_institucion "+
        "FROM institucion "+
        "WHERE id_institucion = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_INSTITUCION", "id_institucion")
            .executeAndFetchFirst(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institucion createInstitucion(Institucion institucion) {
        String sql = 
        "INSERT INTO institucion (nombre_institucion) "+
        "values (:n)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("n", institucion.getNombre_institucion())
                    .executeUpdate()
                    .getKey();
            institucion.setId_institucion(insertedId);
            return institucion;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Institucion updateInstitucion(Institucion institucion){
        String sql =
        "UPDATE institucion "+
        "set nombre_institucion = :n "+
        "WHERE id_institucion = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("n", institucion.getNombre_institucion())
            .executeUpdate();
            return institucion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteInstitucion(Long id){
        String sql =
        "DELETE FROM institucion "+
        "WHERE id_institucion = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
