package com.projets4.tickets.Controller;

import com.projets4.tickets.LogSystem;
import com.projets4.tickets.Model.Classes.ApplicationP;
import com.projets4.tickets.Model.Classes.User;
import com.projets4.tickets.Model.interfaces.ApplicationRepository;
import com.projets4.tickets.Model.interfaces.UserRepository;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *  <h1>A controller to manage administrators queries.</h1>
 *  <h2>An administrator can add/modify/delete user and manage managers</h2>
 *  <table summary="">
 *      <tr>
 *          <th>url</th>
 *          <th>type</th>
 *          <th>use</th>
 *      </tr>
 *      <tr>
 *          <td>/createUser</td>
 *          <td>GET</td>
 *          <td>Redirect to createUser page</td>
 *      </tr>
 *      <tr>
 *          <td>/deleteUser</td>
 *          <td>GET</td>
 *          <td>Redirect to manageUserView page and delete user with id = parameter id</td>
 *      </tr>
 *  </table>
 * */
@Controller
public class AdministratorController {

    @Autowired
    private UserRepository ur;
    @Autowired
    private ApplicationRepository ar;

    //-------------------------------------------------------------------------------------------------------------------

    /**
     *  <h2>Redirect to createUser page</h2>
     * @param session
     * @param model
     * @return link to createUserView page
     * */
    @GetMapping("/createUser")
    public String createUser(Model model, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        model.addAttribute("mode","create");
        model.addAttribute("userModel",new User("login","password","prenom","nom",new Date(),false,false,false,false,null));

        return "createUserView";
    }

    /**
     *  <h2>Redirect to createUser page with user selected information</h2>
     * @param session
     * @param model
     * @param userId
     * @return link to createUserView page
     * */
    @GetMapping("/updateUser")
    public String createUser(Model model, HttpSession session, @RequestParam Long userId){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }
        Optional<User> u = ur.findById(userId); //find if user is already register

        if(u.isPresent()){
            model.addAttribute("mode","update");
            model.addAttribute("userModel",u.get());
        }else{
            //ce cas ne devrait jamais se produire
            LogSystem.addLog(session,"L'utilisateur n'est pas dans la bdd");
            return "redirect:/createUser";
        }

        return "createUserView";
    }

    /**
     *  <h2>Redirect to manageUser page</h2>
     * @param session
     * @return link to manageUserView page
     * */
    @GetMapping("/manageUser")
    public String manageUser(HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        List<User> userList = (List<User>) ur.findAll();
        session.setAttribute("userList",userList);

        return "manageUserView";
    }

    /**
     *  <h2>Redirect to modifyUser page</h2>
     * @param model
     * @param userId
     * @param session
     * @return link to createUserView page
     * */
    /*@GetMapping("/modifyUser")
    public String modifyUser(Model model, @RequestParam Long userId, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }
        Optional<User> userToModify = ur.findById(userId);
        model.addAttribute("userToModify",userToModify.get());

        return "createUserView";
    }*/

    /**
     *  <h2>Redirect to manageUserView page and delete user with id = parameter id</h2>
     * @param userId
     * @param session
     * @return link to manageUserView page
     * */
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        User actualUser = (User) session.getAttribute("user");

        if(actualUser.equals(ur.findById(userId))){
            LogSystem.addLog(session,"Ne peux pas supprimer le profil actuel");
            return "manageUserView";
        }

        List<User> userList = (List<User>) ur.findAllAdmin();
        if(userList.size() <= 1){
            LogSystem.addLog(session,"Ne peux pas supprimer le dernier profil admin");
            return "manageUserView";
        }
        ur.deleteById(userId);
        userList = (List<User>) ur.findAll();
        //model.addAttribute("log", "Utilisateur Supprime");
        session.setAttribute("userList",userList);

        LogSystem.addLog(session,"Utilisateur Supprimé");
        return "manageUserView";
    }

    /**
     *  <h2>Redirect to manageManagerView page</h2>
     * @param model
     * @param session
     * @return link to manageUserView page
     * */
    @GetMapping("/manageManager")
    public String manageManager(Model model, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        List<User> managerList = (List<User>) ur.findAllManager();
        List<ApplicationP> applicationList = (List<ApplicationP>) ar.findAll();
        session.setAttribute("managerList",managerList);
        session.setAttribute("applicationList",applicationList);
        model.addAttribute("application",new ApplicationP());
        //model.addAttribute("log",model.asMap().get("log"));
        //LogSystem.addLog(session,"Utilisateur Supprimé");

        return "manageManagerView";
    }

    /**
     *  <h2>Redirect to manageApplicationView page</h2>
     * @param model
     * @param session
     * @return link to manageApplicationView page
     * */
    @GetMapping("/manageApplication")
    public String manageApplication(Model model, HttpSession session) {
        if (!LogSystem.isAdmin(session)) {
            return "redirect:/";
        }

        List<User> managerList = (List<User>) ur.findAllManager();
        List<ApplicationP> applicationList = (List<ApplicationP>) ar.findAll();
        session.setAttribute("managerList", managerList);
        session.setAttribute("applicationList", applicationList);
        model.addAttribute("application", new ApplicationP());
        //model.addAttribute("log",model.asMap().get("log"));
        //LogSystem.addLog(session,"Utilisateur Supprimé");

        return "manageApplicationView";
    }

    //-------------------------------------------------------------------------------------------------------------------

    /**
     *  <h2>Create or update user in database</h2>
     * @param user
     * @param session
     * @return link to manageUserView page
     * */
    @PostMapping("/createUser")
    public String createUser(User user, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        if(ur.findByLogin(user.getLogin()).size() >= 1){
            LogSystem.addLog(session,"Il existe dejà un utilisateur pour le login : "+user.getLogin());
            //model.addAttribute("log", "Il existe dejà un utilisateur pour le login : "+user.getLogin());
            return "createUserView";
        }

        ur.save(user);

        List<User> userList = (List<User>) ur.findAll();
        //model.addAttribute("log", "Utilisateur Cree : "+user);
        LogSystem.addLog(session,"Utilisateur Cree : "+user);
        session.setAttribute("userList",userList);

        return "manageUserView";
    }

    /**
     *  <h2>Update user in database</h2>
     * @param user
     * @param session
     * @return link to manageUserView page
     * */
    @PostMapping("/updateUser")
    public String updateUser(User user, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        List<User> listUser = ur.findByLogin(user.getLogin());

        if(listUser.size() >= 1){
            //MAJ
            //ur.updateUser(user);
            ur.save(listUser.get(0).update(user));
            //ur.merge(user);

            List<User> userList = (List<User>) ur.findAll();
            session.setAttribute("userList",userList);

            LogSystem.addLog(session,"Utilisateur mis à jour");
            return "manageUserView";
        }else{
            LogSystem.addLog(session,"Impossible de mettre à jour, pas d'utilisateur.");
            return "createUserView";
        }
    }

    /**
     *  <h2>Change or affect manager to application</h2>
     * @param model
     * @param application
     * @param session
     * @return link to redirect to manageManager action
     * */
    @PostMapping("/changeApplication")
    public String changeApplication(Model model, ApplicationP application, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }

        ar.save(application);

        //redirectAttrs.addFlashAttribute("log", "manager changé");
        LogSystem.addLog(session,"Manager changé");
        return "redirect:/manageApplication";
    }

    @GetMapping("/reserveApp")
    public String reserveApp(@RequestParam Long appId, @RequestParam Long managerId, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }
        Optional<ApplicationP> app = ar.findById(appId);
        Optional<User> manager = ur.findById(managerId);
        app.get().setResponsable(manager.get());
        ar.save(app.get());
        LogSystem.addLog(session,"Appli reservée");
        return "redirect:manageManager";
    }

    @GetMapping("/releaseApp")
    public String releaseApp(@RequestParam Long appId, HttpSession session){
        if(!LogSystem.isAdmin(session)){
            return "redirect:/";
        }
        Optional<ApplicationP> app = ar.findById(appId);
        app.get().setResponsable(null);
        ar.save(app.get());
        LogSystem.addLog(session,"Appli libérée");
        return "redirect:manageManager";
    }
}
