package com.projets4.tickets.Controller;

import com.projets4.tickets.LogSystem;
import com.projets4.tickets.Model.Classes.Resolution;
import com.projets4.tickets.Model.Classes.Ticket;
import com.projets4.tickets.Model.Classes.User;
import com.projets4.tickets.Model.interfaces.ResolutionRepository;
import com.projets4.tickets.Model.interfaces.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AgentController {

    @Autowired
    private TicketRepository tr;
    @Autowired
    private ResolutionRepository rr;

    @GetMapping("/manageTicket")
    public String manageTicket(Model model, HttpSession session){
        if(!LogSystem.isAgent(session) && !LogSystem.isCustomer(session)){
            return "redirect:/";
        }
        List<Ticket> ticketList = null;
        if(LogSystem.isAgent(session) && LogSystem.isCustomer(session)) {
            //si les 2 roles : recupere la jointure des listes
            User u = (User) session.getAttribute("user");
            ticketList = (List<Ticket>) tr.findAllNonResolvedByManagerAndByCustomer(u.getResponsable(),u );
        }else if(LogSystem.isAgent(session)){
            // si c'est l'agent qui se connecte : recupere tout les tickets
            // non-résolus dont l'application est dans la liste des
            // applications affectées au responsable de l'agent

            User agent = (User) session.getAttribute("user");
            ticketList = (List<Ticket>) tr.findAllNonResolvedByManager(agent.getResponsable());
            //ticketList = (List<Ticket>) tr.findAllNonResolved();

        }else{
            //recupere les tickets du client si celui-ci se connecte
            ticketList = (List<Ticket>) tr.findByCustomer((User) session.getAttribute("user"));
        }
        session.setAttribute("ticketList",ticketList);

        return "manageTicketView";
    }

    @GetMapping("/reserveTicket")
    public String reserveTicket(@RequestParam Long ticketId, HttpSession session){
        if(!LogSystem.isAgent(session)){
            return "redirect:/";
        }
        Optional<Ticket> ticket = tr.findById(ticketId);
        ticket.get().setReservedBy((User) session.getAttribute("user"));
        tr.save(ticket.get());
        LogSystem.addLog(session,"Ticket reservé");
        return "redirect:manageTicket";
    }

    @GetMapping("/resolveTicket")
    public String resolveTicket(Model model,@RequestParam Long ticketId, HttpSession session){
        if(!LogSystem.isAgent(session)){
            return "redirect:/";
        }
        Optional<Ticket> ticket = tr.findById(ticketId);

        model.addAttribute("ticketItem",ticket.get());
        model.addAttribute("resolution",new Resolution());

        //LogSystem.addLog(session,"Ticket reservé");
        return "resolveTicketView";
    }

    @GetMapping("/releaseTicket")
    public String releaseTicket(@RequestParam Long ticketId, HttpSession session){
        if(!LogSystem.isAgent(session)){
            return "redirect:/";
        }
        Optional<Ticket> ticket = tr.findById(ticketId);
        ticket.get().setReservedBy(null);
        tr.save(ticket.get());
        LogSystem.addLog(session,"Ticket libéré");
        return "redirect:manageTicket";
    }


    @PostMapping("/resolveTicket")
    public String resolveTicket(Resolution resolution, HttpSession session){
        if(!LogSystem.isAgent(session)){
            return "redirect:/";
        }
        rr.save(resolution);

        //redirectAttrs.addFlashAttribute("log", "ticketResolu");
        LogSystem.addLog(session,"Ticket résolu");
        return "redirect:/manageTicket";
    }
}
