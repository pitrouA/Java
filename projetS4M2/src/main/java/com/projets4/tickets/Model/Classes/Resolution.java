package com.projets4.tickets.Model.Classes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Resolution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    private Ticket ticket;
    @ManyToOne
    private User resolvedBy;

    public Resolution() {}

    public Resolution(String description, Ticket ticket) {
        this.description = description;
        this.ticket = ticket;
    }

    public Resolution(String description, Ticket ticket, User resolvedBy) {
        this.description = description;
        this.ticket = ticket;
        this.resolvedBy = resolvedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(User resolvedBy) {
        this.resolvedBy = resolvedBy;
    }
}
