package com.projets4.tickets.Model.interfaces;

import com.projets4.tickets.Model.Classes.Resolution;
import com.projets4.tickets.Model.Classes.Ticket;
import com.projets4.tickets.Model.Classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This is an Interface.
// No need Annotation here.
public interface ResolutionRepository extends CrudRepository<Resolution, Long> {

    //@Query("select r from Resolution r where r.resolvedBy.id = ?1")
    //List<Resolution> findByAgentId(Long id);

    @Query("select r from Resolution r where r.resolvedBy = ?1")
    List<Resolution> findByAgent(User agent);
}