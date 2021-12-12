package com.informatorio.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;
import com.informatorio.proyectoFinal.DAO.VotesDAO;
import com.informatorio.proyectoFinal.entity.Votes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("votes")
public class VotesController {

    @Autowired
    private VotesDAO votesDAO;

    @GetMapping
    public ResponseEntity<List<Votes>> getVotes(){
        List<Votes> votes = votesDAO.findAll();
        return ResponseEntity.ok(votes);
    }
    @RequestMapping(value="{votesId}")
    public ResponseEntity<Votes> getVotesById(@PathVariable("votesId") Long votesId){
        Optional<Votes> votesById = votesDAO.findById(votesId);
        if(votesById.isPresent()){
            return ResponseEntity.ok(votesById.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<Votes> createVotes(@RequestBody Votes votes){
        Votes newVotes = votesDAO.save(votes);
        return ResponseEntity.ok(newVotes);
    }
    @DeleteMapping(value="{votesId}")
    public ResponseEntity<Void> deleteVotes(@PathVariable("votesId") Long votesId){
        votesDAO.deleteById(votesId);
        return ResponseEntity.ok(null);
    }
    @PutMapping
    public ResponseEntity<Votes> updateVotes(@RequestBody Votes votes){
        Optional<Votes> updateVotes = votesDAO.findById(votes.getId());
        if(updateVotes.isPresent()){
            Votes votesUpdate = updateVotes.get();
            votesUpdate.setGenerateBy(votes.getGenerateBy());
            votesUpdate.setUsername(votes.getUsername());
            votesUpdate.setDateCreation(votes.getDateCreation());
            votesUpdate.setObservation(votes.getObservation());
            votesDAO.save(votesUpdate);
            return ResponseEntity.ok(votesUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
