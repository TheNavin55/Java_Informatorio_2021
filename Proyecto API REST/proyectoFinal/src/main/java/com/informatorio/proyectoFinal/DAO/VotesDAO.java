package com.informatorio.proyectoFinal.DAO;


import com.informatorio.proyectoFinal.entity.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesDAO extends JpaRepository<Votes, Long>{
    
}
