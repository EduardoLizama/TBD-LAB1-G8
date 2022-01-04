package com.tbd.lab1.repositories;

import java.util.List;

import com.tbd.lab1.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class rankingRepositoryImp implements rankingRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAllRankings(){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking")
            .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking getRanking(Long id) {
        String sql =
        "SELECT id_voluntario, id_tarea , nombre "+
        "FROM ranking "+
        "WHERE id_ranking = :id";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
            .addParameter("id", id)
            .addColumnMapping("ID_RANKING", "id_ranking")
            .executeAndFetchFirst(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking createRanking(Ranking ranking) {
        String sql = 
        "INSERT INTO ranking (id_voluntario, id_tarea, nombre) "+
        "values (:id_v, :id_t, :n)";

        try(Connection conn = sql2o.open()){
            Long insertedId = (Long) conn.createQuery(sql, true)
                    .addParameter("id_v", ranking.getId_voluntario())
                    .addParameter("id_t", ranking.getId_tarea())
                    .addParameter("n", ranking.getEstadotarea())
                    .executeUpdate()
                    .getKey();
            ranking.setId_ranking(insertedId);
            return ranking;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Ranking updateRanking(Ranking ranking){
        String sql =
        "UPDATE ranking "+
        "set id_voluntario = :id_t, id_tarea = :id_t, nombre = :n "+
        "WHERE id_ranking = :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id_v", ranking.getId_voluntario())
            .addParameter("id_t", ranking.getId_tarea())
            .addParameter("n", ranking.getEstadotarea())
            .executeUpdate();
            return ranking;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteRanking(Long id){
        String sql =
        "DELETE FROM ranking "+
        "WHERE id_ranking= :id";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //@Override
    public void completeVolTarea(Long id_Vol, Long id_tar){
        String sql =
        "Update ranking "+
        "set estadotarea='Completada' "+
        "WHERE id_voluntario= :idVol and id_tarea = :idTar";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("idVol", id_Vol)
            .addParameter("idTar", id_tar)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelRanking(Long id_Vol, Long id_tar){
        String sql =
        "Update ranking "+
        "set estadotarea='Cancelada' "+
        "WHERE id_voluntario= :idVol and id_tarea = :idTar";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql, false)
            .addParameter("idVol", id_Vol)
            .addParameter("idTar", id_tar)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStateTarea(Long id){
        String sql =
        "CALL updateStateTask(:id)";

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
            .addParameter("id", id)
            .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
