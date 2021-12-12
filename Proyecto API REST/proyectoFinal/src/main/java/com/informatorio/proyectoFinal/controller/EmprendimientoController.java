package com.informatorio.proyectoFinal.controller;

import java.util.List;
import java.util.Optional;

import com.informatorio.proyectoFinal.DAO.EmprendimientosDAO;
import com.informatorio.proyectoFinal.entity.Emprendimiento;

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
@RequestMapping("emprendimientos")
public class EmprendimientoController {
    
    @Autowired
    private EmprendimientosDAO emprendimientosDAO;

    @GetMapping
    public ResponseEntity<List<Emprendimiento>> getEmprendimiento(){
        List<Emprendimiento> emprendimientos = emprendimientosDAO.findAll();
        return ResponseEntity.ok(emprendimientos);
    }
    @RequestMapping(value="{emprendimientoId}")
    public ResponseEntity<Emprendimiento> getEmprendimientoById(@PathVariable("emprendimietoId") Long emprendimientoId){
        Optional<Emprendimiento> emprendimientoById = emprendimientosDAO.findById(emprendimientoId);
        if(emprendimientoById.isPresent()){
            return ResponseEntity.ok(emprendimientoById.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<Emprendimiento> createEmprendimiento(@RequestBody Emprendimiento emprendimiento){
        Emprendimiento newEmprendimiento = emprendimientosDAO.save(emprendimiento);
        return ResponseEntity.ok(newEmprendimiento);
    }
    @DeleteMapping(value="{emprendimientoId}")
    public ResponseEntity<Void> deleteEmprendimiento(@PathVariable("emprendimientoId") Long emprendimientoId){
        emprendimientosDAO.deleteById(emprendimientoId);
        return ResponseEntity.ok(null);
    }
    @PutMapping
    public ResponseEntity<Emprendimiento> updateEmprendimiento(@RequestBody Emprendimiento emprendimiento){
        Optional<Emprendimiento> UpdateEmprendimiento = emprendimientosDAO.findById(emprendimiento.getId());
        if(UpdateEmprendimiento.isPresent()){
            Emprendimiento emprendimientoUpdate = UpdateEmprendimiento.get();
            emprendimientoUpdate.setName(emprendimiento.getName());
            emprendimientoUpdate.setDescription(emprendimiento.getDescription());
            emprendimientoUpdate.setContent(emprendimiento.getContent());
            emprendimientoUpdate.setDateCreation(emprendimiento.getDateCreation());
            emprendimientoUpdate.setObjective(emprendimiento.getObjective());
            emprendimientoUpdate.setPublished(emprendimiento.getPublished());
            emprendimientoUpdate.setUrl(emprendimiento.getUrl());
            emprendimientoUpdate.setTags(emprendimiento.getTags());
            emprendimientosDAO.save(emprendimientoUpdate);
            return ResponseEntity.ok(emprendimientoUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
