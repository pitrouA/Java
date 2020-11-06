package com.projets4.tickets.Controller;

import com.projets4.tickets.LogSystem;
import com.projets4.tickets.Model.Classes.ApplicationP;
import com.projets4.tickets.Model.Classes.Resolution;
import com.projets4.tickets.Model.Classes.User;
import com.projets4.tickets.Model.interfaces.ApplicationRepository;
import com.projets4.tickets.Model.interfaces.ResolutionRepository;
import com.projets4.tickets.Model.interfaces.TicketRepository;
import com.projets4.tickets.Model.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ManagerController {

    @Autowired
    private UserRepository ur;
    @Autowired
    private ApplicationRepository ar;
    @Autowired
    private ResolutionRepository rr;
    @Autowired
    private TicketRepository tr;

    @GetMapping("/manageAgent")
    public String manageAgent(HttpSession session){
        if(!LogSystem.isManager(session)){
            return "redirect:/";
        }
        List<User> agentList = ur.findAllAgentsByManager((User)session.getAttribute("user"));

        session.setAttribute("agentList",agentList);

        return "manageAgentView";
    }

    @GetMapping("/detailAgent")
    public String detailAgent(Model model, @RequestParam Long userId, HttpSession session){
        if(!LogSystem.isManager(session)){
            return "redirect:/";
        }
        Optional<User> agent = ur.findById(userId);

        model.addAttribute("agent",agent.get());
        model.addAttribute("ticketList",tr.findByCustomer(agent.get()));
        model.addAttribute("resolutionList",rr.findByAgent(agent.get()));
        model.addAttribute("applicationList",(List<ApplicationP>) ar.findAllByManager(agent.get().getResponsable()));

        return "detailAgentView";
    }

    @GetMapping("/manageResolution")
    public String manageResolution(HttpSession session){
        if(!LogSystem.isManager(session) && !LogSystem.isAgent(session)){
            return "redirect:/";
        }
        if(LogSystem.isManager(session)){
            //le manager recupere tout
            session.setAttribute("resolutionList",(List<Resolution>) rr.findAll());
        }else{
            //l'agent ne recupere que ses propres resolutions
            session.setAttribute("resolutionList",rr.findByAgent((User) session.getAttribute("user")));
        }

        return "manageResolutionView";
    }

    @GetMapping("/reserveAgent")
    public String reserveAgent(@RequestParam Long agentId, HttpSession session){
        if(!LogSystem.isManager(session)){
            return "redirect:/";
        }
        Optional<User> agent = ur.findById(agentId);
        agent.get().setResponsable((User) session.getAttribute("user"));
        ur.save(agent.get());
        LogSystem.addLog(session,"Agent reservé");
        return "redirect:manageAgent";
    }

    @GetMapping("/releaseAgent")
    public String releaseAgent(@RequestParam Long agentId, HttpSession session){
        if(!LogSystem.isManager(session)){
            return "redirect:/";
        }
        Optional<User> agent = ur.findById(agentId);
        agent.get().setResponsable(null);
        ur.save(agent.get());
        LogSystem.addLog(session,"Agent libéré");
        return "redirect:manageAgent";
    }
}
