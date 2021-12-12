package com.informatorio.proyectoFinal.DAO;


import com.informatorio.proyectoFinal.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprendimientosDAO extends JpaRepository<Emprendimiento, Long>{

}
