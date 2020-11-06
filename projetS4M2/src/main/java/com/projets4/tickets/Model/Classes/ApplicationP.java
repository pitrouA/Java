package com.projets4.tickets.Model.Classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ApplicationP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    @ManyToOne
    private User responsable;

    public ApplicationP() {}

    public ApplicationP(String nom) {
        this.nom = nom;
    }

    public ApplicationP(String nom, User responsable) {
        this.nom = nom;
        this.responsable = responsable;
    }

    public ApplicationP(String nom, String description, User responsable) {
        this.nom = nom;
        this.description = description;
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "ApplicationP{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
