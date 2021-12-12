package com.informatorio.proyectoFinal.DAO;

import com.informatorio.proyectoFinal.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsDAO extends JpaRepository<Event, Long>{
    
}
