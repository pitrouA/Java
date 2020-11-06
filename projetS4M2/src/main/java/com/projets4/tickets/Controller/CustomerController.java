package com.projets4.tickets.Controller;

import com.projets4.tickets.LogSystem;
import com.projets4.tickets.Model.Classes.ApplicationP;
import com.projets4.tickets.Model.Classes.Ticket;
import com.projets4.tickets.Model.Classes.User;
import com.projets4.tickets.Model.interfaces.ApplicationRepository;
import com.projets4.tickets.Model.interfaces.TicketRepository;
import com.projets4.tickets.Model.interfaces.UserRepository;
import com.sun.glass.ui.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private TicketRepository tr;

    @Autowired
    ApplicationRepository ar;

    @GetMapping("/createTicket")
    public String createTicket(Model model, HttpSession session){
        if(!LogSystem.isCustomer(session)){
            return "redirect:/";
        }
        List<ApplicationP> applicationList = (List<ApplicationP>) ar.findAll();

        session.setAttribute("applicationList",applicationList);
        model.addAttribute("ticket", new Ticket());

        return "createTicketView";
    }

    //-------------------------------------------------------------------------------------------------------------------

    @PostMapping("/createTicket")
    public String createTicket(Model model, Ticket ticket, HttpSession session){
        if(!LogSystem.isCustomer(session)){
            return "redirect:/";
        }
        LogSystem.addLog(session,"Ticket crée");

        tr.save(ticket);

        //List<Ticket> ticketList = (List<Ticket>) tr.findAll();
        //session.setAttribute("ticketList",ticketList);
        //model.addAttribute("log", "Ticket cree : "+ticket);

        return "redirect:/manageTicket";
    }
}
