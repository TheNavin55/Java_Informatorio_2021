package com.informatorio.proyectoFinal.converter;

import java.time.LocalDateTime;
import com.informatorio.proyectoFinal.dto.VotoDTO;
import com.informatorio.proyectoFinal.entity.Voto;
import com.informatorio.proyectoFinal.repository.EmprendimientoRepository;
import com.informatorio.proyectoFinal.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                  UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    } 
}