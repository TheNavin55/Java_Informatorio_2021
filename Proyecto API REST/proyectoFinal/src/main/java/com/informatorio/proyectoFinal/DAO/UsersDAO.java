package com.informatorio.proyectoFinal.DAO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.informatorio.proyectoFinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<User, Long>{

    User  findByUsername(String username);
    List<User> findByCreatedDateAfter(LocalDateTime localDateTime);
    List<User> findByCity(String city);
    
}
