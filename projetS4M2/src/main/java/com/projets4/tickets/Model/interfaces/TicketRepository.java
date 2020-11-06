package com.projets4.tickets.Model.interfaces;

import com.projets4.tickets.Model.Classes.ApplicationP;
import com.projets4.tickets.Model.Classes.Resolution;
import com.projets4.tickets.Model.Classes.Ticket;
import com.projets4.tickets.Model.Classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This is an Interface.
// No need Annotation here.
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    //@Query("select t from Ticket t where t.reservedBy.id = ?1")
    //List<Ticket> findByAgentId(Long id);

    @Query("select r.ticket from Resolution r")
    List<Ticket> findAllResolved();

    @Query("select t from Ticket t where t not in (select r.ticket from Resolution r)")
    List<Ticket> findAllNonResolved();

    @Query("select t from Ticket t where t not in (select r.ticket from Resolution r) and (t.application.responsable = ?1 or t.application.responsable is null)")
    List<Ticket> findAllNonResolvedByManager(User manager);

    @Query("select t from Ticket t where t.postedBy = ?1")
    List<Ticket> findByCustomer(User customer);

    @Query("select t from Ticket t where t not in (select r.ticket from Resolution r) or t.postedBy = ?1 or t.postedBy is null")
    List<Ticket> findNonResolvedAndByUser(User user);

    @Query("select t from Ticket t where (t not in (select r.ticket from Resolution r) and (t.application.responsable = ?1 or t.application.responsable is null)) or t.postedBy = ?1 or t.postedBy is null")
    List<Ticket> findAllNonResolvedByManagerAndByCustomer(User manager, User customer);
}
