package com.tbd.lab1.services;

import com.tbd.lab1.models.Ranking;
import com.tbd.lab1.repositories.rankingRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin
@RestController
public class rankingService {
    
    private final rankingRepository rankingRepository;
    rankingService(rankingRepository rankingRepository){
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/ranking")
    public List<Ranking> getAllRankings() {
        return rankingRepository.getAllRankings();
    }

    @GetMapping("/ranking/mostrar/{id}")
    public Ranking getRanking(@PathVariable(name = "id") Long id) {
        return rankingRepository.getRanking(id);
    }

    @PostMapping("/ranking/create")
    @ResponseBody
    public Ranking createRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.createRanking(ranking);
        return result;
    }

    @PutMapping("/ranking/update/{id}")
    @ResponseBody
    public Ranking updateRanking(@PathVariable(name = "id") Long id, @RequestBody Ranking ranking) {

        Ranking ranking_seleccionado = new Ranking();
        Ranking ranking_actualizado = new Ranking();

        int flag = 0;

        ranking_seleccionado = rankingRepository.getRanking(id);
        if (ranking.getEstadotarea() != null){
            ranking_seleccionado.setEstadotarea(ranking.getEstadotarea());
            if(ranking_seleccionado.getEstadotarea().equals("Completada")){
                flag = 1;
            }
        }
        if (ranking.getId_voluntario() != null) ranking_seleccionado.setId_voluntario(ranking.getId_voluntario());
        if (ranking.getId_tarea() != null) ranking_seleccionado.setId_tarea(ranking.getId_tarea());

        ranking_actualizado = rankingRepository.updateRanking(ranking_seleccionado);

        if(flag == 1){
            rankingRepository.updateStateTarea(ranking_actualizado.getId_tarea());
        }

        return ranking_actualizado;
    }

    @DeleteMapping("/ranking/delete/{id}")
    public void deleteRanking(@PathVariable(name = "id") Long id){
        rankingRepository.deleteRanking(id);
    }

    @GetMapping("/ranking/cancel/{id_Vol}/{id_tar}")
    public void cancelRanking(@PathVariable Long id_Vol, @PathVariable Long id_tar){
        rankingRepository.cancelRanking(id_Vol, id_tar);
    }

    @GetMapping("/ranking/completeTarea/{id_Vol}/{id_tar}")
    public void completeVolTarea(@PathVariable Long id_Vol, @PathVariable Long id_tar){
        rankingRepository.completeVolTarea(id_Vol, id_tar);
        rankingRepository.updateStateTarea(id_tar);
    }
}
