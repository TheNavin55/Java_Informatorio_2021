package com.informatorio.proyectoFinal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.informatorio.proyectoFinal.dto.EventoDTO;
import com.informatorio.proyectoFinal.entity.Emprendimiento;
import com.informatorio.proyectoFinal.entity.Estado;
import com.informatorio.proyectoFinal.entity.Evento;
import com.informatorio.proyectoFinal.repository.EmprendimientoRepository;
import com.informatorio.proyectoFinal.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableScheduling
public class EventoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final EventoRepository eventoRepository;
    @Autowired
    public EventoService(EmprendimientoRepository emprendimientoRepository,
                         EventoRepository eventoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.eventoRepository = eventoRepository;
    }
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }
    public Evento eliminar(Long id, Evento evento) {
        Evento eventoEliminado = eventoRepository.getById(id);
        eventoEliminado.setActivo(false);
        return eventoRepository.save(eventoEliminado);
    }
    public void actualizarEstado(Evento evento, LocalDate ahora) {
        if (evento.getFechaDeInicio().isBefore(ahora)) { evento.setEstado(Estado.IN_COURSE); }
        if (evento.getFechaFinal().isBefore(ahora)) { evento.setEstado(Estado.FINALIZED); }
    }
    public void actualizar() {
        List<Evento> eventos = eventoRepository.findAll();
        LocalDate ahora = LocalDate.now();
        eventos.stream().forEach(evento -> actualizarEstado(evento, ahora));
        eventoRepository.saveAll(eventos);
        System.out.println("Estado del evento actualizado.");
    }
    public Emprendimiento registrar(Long emprendimientoId, Long eventoId, EventoDTO eventoDTO) {
        Emprendimiento emprendimientoRegistrado = emprendimientoRepository.getById(emprendimientoId);
        Evento eventoRegistrado = eventoRepository.getById(eventoId);
        if (eventoRegistrado.getEstado() == Estado.OPEN) { emprendimientoRegistrado.addEvento(eventoRegistrado);
            System.out.println("Suscripcion correcta");
        } else if (eventoRegistrado.getEstado() == Estado.IN_COURSE) { 
            System.out.println("Tiempo de suscripcion finalizado");
        } else { System.out.println("Evento finalizado."); }
        return emprendimientoRepository.save(emprendimientoRegistrado);
    }
    public Optional<Evento> rankear(Long id) {
        return eventoRepository.findById(id);
    }
}