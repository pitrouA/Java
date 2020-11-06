package com.projets4.tickets.Controller;

import com.projets4.tickets.LogSystem;
import com.projets4.tickets.Model.Classes.*;
import com.projets4.tickets.Model.interfaces.*;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository ur;
    @Autowired
    private ApplicationRepository ar;
    @Autowired
    private TicketRepository tr;
    @Autowired
    private ResolutionRepository rr;
    @Autowired
    EntityManager em;

    @PostConstruct
    public void init() {
        /*User u = new User("alice","alice2",true,true,true,true);
        ur.save(u);
        User u2 = new User("bob","bob",true,true,true,true);
        ur.save(u2);
        ur.save(new User("aliceLaVraie","alice",true,true,false,false));
        ur.save(new User("a","a",false,true,true,false));
        ur.save(new User("fdgdg","fdgsdfg",false,true,false,true));
        */
        User admin1 = new User("admin1","admin1",true,false,false,false);
        User admin2 = new User("admin2","admin2",true,false,false,false);
        ur.save(admin1);
        ur.save(admin2);
        User manager1 = new User("manager1","manager1",false,true,false,false);
        User manager2 = new User("manager2","manager2",false,true,false,false);
        ur.save(manager1);
        ur.save(manager2);
        User all= new User("all","all","Christian","Grey",new Date(),true,true,true,true,manager1);
        ur.save(all);
        User agent1 = new User("agent1","agent1","Titouan","Dupont",new Date(),false,false,true,false,manager1);
        User agent2 = new User("agent2","agent2","Adelaide","Marge",new Date(),false,false,true,false,manager2);
        User agent3 = new User("agent3","agent3","Dudelet","Dupond",new Date(),false,false,true,false,manager1);
        User agent4 = new User("agent4","agent4","Trista","Ralèse",new Date(),false,false,true,false,all);
        User agent5 = new User("agent5","agent5","Karine","Braème",new Date(),false,false,true,false,all);
        ur.save(agent1);
        ur.save(agent2);
        ur.save(agent3);
        ur.save(agent4);
        ur.save(agent5);
        User customer1 = new User("customer1","customer1",false,false,false,true);
        User customer2 = new User("customer2","customer2",false,false,false,true);
        User customer3 = new User("customer3","customer3",false,false,false,true);
        ur.save(customer1);
        ur.save(customer2);
        ur.save(customer3);

        //---------------------------------------------------------------------------------

        ApplicationP freecel = new ApplicationP("freecel","Un jeu vraiment basique",manager1);
        ar.save(freecel);
        ApplicationP ib = new ApplicationP("ib","Les OST et le background de ce jeu sont extraordinaires.",manager1);
        ar.save(ib);
        ApplicationP yume_nikki = new ApplicationP("yume nikki","Le jeu RPG-Maker de référence.",manager2);
        ar.save(yume_nikki);
        ApplicationP pvz = new ApplicationP("plantes vs zombies","Un tower défense très sympathique.",all);
        ar.save(pvz);
        ApplicationP madfather = new ApplicationP("mad father","Un jeu à énigme vraiment très particulier",all);
        ar.save(madfather);
        ApplicationP pokémonNoir_blanc = new ApplicationP("pokémonNoir_blanc","Les pokémons :-3",manager2);
        ar.save(pokémonNoir_blanc);

        //ApplicationP c = new ApplicationP("ttttt",u);
        //ar.save(c);

        //---------------------------------------------------------------------------------

        Ticket t_free = new Ticket("aidez-moi !",new Date(),"en fait, ça craint.",freecel,agent1,customer1);
        tr.save(t_free);
        Ticket t_ib =  new Ticket("ib",new Date(),"probleme avec ib ? ou pas...",ib,agent2,customer1);
        tr.save(t_ib);
        Ticket t_ib2 = new Ticket("Pas de soucis",new Date(),"Pas de probleme",ib, agent3,customer1);
        tr.save(t_ib2);
        Ticket t_free1 = new Ticket("rte",new Date(),"rte",freecel,agent1,customer1);
        tr.save(t_free1);
        Ticket t_free2 = new Ticket("rte",new Date(),"rte",freecel,agent1,customer1);
        tr.save(t_free2);
        Ticket t_free3 = new Ticket("bbbbb",new Date(),"bbbbb",pvz,agent1,customer1);
        tr.save(t_free3);
        Ticket t_pok1 = new Ticket("pok",new Date(),"pok",pvz,null,customer1);
        tr.save(t_pok1);
        tr.save(new Ticket("pvz-blem",new Date(),"le jeu crash sans raison au démarrage.",pvz,agent3,customer1));
        tr.save(new Ticket("nikki-blem",new Date(),"Le jeu tourne mal",yume_nikki,null,customer1));
        tr.save(new Ticket("nikki-blem2",new Date(),"Le jeu tourne vraiment très mal",yume_nikki,null,customer2));
        tr.save(new Ticket("free-blem",new Date(),"freecel sans cellule",freecel,agent1,customer1));
        tr.save(new Ticket("free-blem2",new Date(),"freecel tourne trop vite",freecel,agent1,customer1));
        tr.save(new Ticket("free-blem3",new Date(),"freecel sans free",freecel,null,customer2));
        tr.save(new Ticket("mad-blem",new Date(),"mad father est devenu fou !",madfather,agent1,customer2));
        tr.save(new Ticket("mad-blem2",new Date(),"mad father est devenu encore plus fou !",madfather,null,customer2));
        tr.save(new Ticket("mad-blem3",new Date(),"mad father est devenu encore, encore plus fou !",madfather,null,customer1));
        tr.save(new Ticket("pok-blem1",new Date(),"Les pokémons sont des problèmes",pokémonNoir_blanc,null,customer1));

        //---------------------------------------------------------------------------------

        rr.save(new Resolution("Pas de probleme avec ib",t_ib,agent2));
        rr.save(new Resolution("Pas de probleme avec ib",t_ib2,agent3));
        rr.save(new Resolution("Freecel resolu",t_free,agent1));
        rr.save(new Resolution("gggr, Résolu !",t_free1,agent1));
        rr.save(new Resolution("gggr, Résolu2 !",t_free2,agent4));
        rr.save(new Resolution("gggr, Résolu3 !",t_free3,agent1));
        rr.save(new Resolution("gggr, Résolu3 !",t_pok1,agent2));
    }

    @GetMapping({"/login"})
    public String loginRedirect(HttpSession session){
        session.removeAttribute("user");
        return "loginView";
    }

    @GetMapping({"/disconnect"})
    public String disconnect(Model model, HttpSession session){
        if(!LogSystem.isUser(session)){ //ne peux pas se deconnecter si pas deja loggue
            return "redirect:/";
        }
        session.removeAttribute("user");
        //model.addAttribute("msg",model.asMap().get("msg"));
        LogSystem.addLog(session,"Deconnecté");
        return "redirect:/";
    }


    @PostMapping({"/login"})
    public String login(User user, HttpSession session) {
        //Customer customer = new Customer("nom","mail","adresse");
        //customer.setName("adrien");

        List<User> userList = ur.findByLoginAndPassword(user.getLogin(),user.getPassword());

        if(userList.size() <= 0){
            //redirectAttrs.addFlashAttribute("log", "Mauvais Login ou mot de passe. Veuillez réessayer.");
            LogSystem.addLog(session,"Mauvais Login ou mot de passe. Veuillez réessayer.");
            //return new RedirectView("/loginRedirect",true);
            return "redirect:/login";
        }

        session.setAttribute("user",userList.get(0));
        LogSystem.addLog(session,"Connecté avec le login : "+user.getLogin());
        //redirectAttrs.addFlashAttribute("user", userList.get(0));

        RedirectView rv = new RedirectView("/main",true);
        //rv.addStaticAttribute("user",user);
        return "redirect:/main";
    }
}

