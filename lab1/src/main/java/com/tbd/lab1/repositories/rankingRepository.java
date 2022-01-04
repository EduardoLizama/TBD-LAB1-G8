package com.tbd.lab1.repositories;

import java.util.List;
import com.tbd.lab1.models.Ranking;

public interface rankingRepository {
    public List<Ranking> getAllRankings();
    public Ranking getRanking(Long id);
    public Ranking createRanking(Ranking ranking);
    public Ranking updateRanking(Ranking ranking);
    public void deleteRanking(Long id);
    public void completeVolTarea(Long id_Vol, Long id_tar);
    public void cancelRanking(Long id_Vol, Long id_tar);
    public void updateStateTarea(Long id);
}
