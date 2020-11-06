package com.projets4.tickets.Controller;

import com.projets4.tickets.Model.Classes.User;
import com.projets4.tickets.Model.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {
    @Autowired
    private UserRepository ur;

    @GetMapping({"/main"})
    public String main(Model model, HttpSession session) {
        return "mainPageView";
    }

    @GetMapping({"/"})
    public String mainRedirect(){
        return "redirect:/main";
    }

    @GetMapping({"/history"})
    public String history(){
        return "historyView";
    }

    @GetMapping({"/applications"})
    public String applications(){
        return "applicationsView";
    }
}
