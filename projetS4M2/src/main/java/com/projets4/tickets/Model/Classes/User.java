package com.projets4.tickets.Model.Classes;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String prenom;
    private String nom;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDate;
    private boolean isAdmin;
    private boolean isManager;
    private boolean isAgent;
    private boolean isCustomer;
    @ManyToOne
    private User responsable;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
        //do nothing
    }

    public User(String login, String password, String prenom, String nom, Date dateNaissance, boolean isAdmin, boolean isManager, boolean isAgent, boolean isCustomer) {
        this.login = login;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.birthDate = dateNaissance;
        this.isAdmin = isAdmin;
        this.isManager = isManager;
        this.isAgent = isAgent;
        this.isCustomer = isCustomer;
    }

    public User(String login, String password, boolean isAdmin, boolean isManager, boolean isAgent, boolean isCustomer) {
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isManager = isManager;
        this.isAgent = isAgent;
        this.isCustomer = isCustomer;
    }

    public User(String login, String password, String prenom, String nom, Date dateNaissance, boolean isAdmin, boolean isManager, boolean isAgent, boolean isCustomer, User responsable) {
        this.login = login;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.birthDate = dateNaissance;
        this.isAdmin = isAdmin;
        this.isManager = isManager;
        this.isAgent = isAgent;
        this.isCustomer = isCustomer;
        this.responsable = responsable;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean isAgent() {
        return isAgent;
    }

    public void setAgent(boolean agent) {
        isAgent = agent;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + birthDate +
                ", isAdmin=" + isAdmin +
                ", isManager=" + isManager +
                ", isAgent=" + isAgent +
                ", isCustomer=" + isCustomer +
                ", responsable=" + responsable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public User update(User user) {
        this.login = user.login;
        this.password = user.password;
        this.prenom = user.prenom;
        this.nom = user.nom;
        this.isAdmin = user.isAdmin;
        this.isAgent = user.isAgent;
        this.isCustomer = user.isCustomer;
        this.isManager = user.isManager;
        this.birthDate = user.birthDate;
        this.responsable = user.responsable;

        return this;
    }
}
