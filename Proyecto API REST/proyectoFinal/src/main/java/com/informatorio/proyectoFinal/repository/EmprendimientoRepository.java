package com.informatorio.proyectoFinal.repository;

import com.informatorio.proyectoFinal.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long> {
}