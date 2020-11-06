package com.projets4.tickets.Model.Classes;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private String description;
    @ManyToOne
    private ApplicationP application;
    @ManyToOne
    private User reservedBy;
    @ManyToOne
    private User postedBy;

    public Ticket() {}

    public Ticket(String title, Date date, String description, ApplicationP application) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.application = application;
    }

    public Ticket(String title, Date date, String description, ApplicationP application, User reservedBy) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.application = application;
        this.reservedBy = reservedBy;
    }

    public Ticket(String title, Date date, String description, ApplicationP application, User reservedBy, User postedBy) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.application = application;
        this.postedBy = postedBy;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplicationP getApplication() {
        return application;
    }

    public void setApplication(ApplicationP appli) {
        this.application = appli;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", application=" + application +
                ", reservedBy=" + reservedBy +
                ", postedBy=" + postedBy +
                '}';
    }
}
