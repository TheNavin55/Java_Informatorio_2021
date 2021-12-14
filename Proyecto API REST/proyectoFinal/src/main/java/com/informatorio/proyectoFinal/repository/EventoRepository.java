package com.informatorio.proyectoFinal.repository;

import com.informatorio.proyectoFinal.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {   
}