package com.informatorio.proyectoFinal.repository;

import com.informatorio.proyectoFinal.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByNombre(String nombre);
}