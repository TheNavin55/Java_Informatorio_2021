package com.informatorio.proyectoFinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "vote")
public class Votes {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="generateBy")
    private GeneratedFrom generateBy;

    @Column(name="username")
    private String username;

    @Column(name="dateCreation")
    private LocalDate dateCreation;

    @Column(name="Observation")
    private String observation;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneratedFrom getGenerateBy() {
        return this.generateBy;
    }

    public void setGenerateBy(GeneratedFrom generateBy) {
        this.generateBy = generateBy;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

}
