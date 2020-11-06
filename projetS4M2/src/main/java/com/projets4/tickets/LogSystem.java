package com.projets4.tickets;

import com.projets4.tickets.Model.Classes.User;

import javax.servlet.http.HttpSession;

public class LogSystem {

    public static final int LOG_LIMIT = 10;
    private static int i=0;

    //ininstanciable
    private LogSystem(){};

    /**
     * Méthode pour gérer les logs en session
     * */
    public static void addLog(HttpSession session, String message){
        String log = (String) session.getAttribute("log");
        log = "# "+message + log + "<br/>";
        i++;
        //eviter que trop de logs s'accumulent
        if(i >= LOG_LIMIT){
            log = log.substring(0,findLastLog(log));
        }

        session.setAttribute("log",log);
    }

    private static int findLastLog(String s){
        int j=0;
        for(int k=0;k<s.length()-1;k++){
            if(s.charAt(k) == '#'){
                j++;
            }
            if(j>=LOG_LIMIT){
                return k;
            }
        }

        return s.length();
    }

    public static boolean isAdmin(HttpSession session){
        if(isUser(session) && ((User) session.getAttribute("user")).isAdmin()){
            return true;
        }
        return false;
    }

    public static boolean isManager(HttpSession session){
        if(isUser(session) && ((User) session.getAttribute("user")).isManager()){
            return true;
        }
        return false;
    }

    public static boolean isAgent(HttpSession session){
        if(isUser(session) && ((User) session.getAttribute("user")).isAgent()){
            return true;
        }
        return false;
    }

    public static boolean isCustomer(HttpSession session){
        if(isUser(session) && ((User) session.getAttribute("user")).isCustomer()){
            return true;
        }
        return false;
    }

    public static boolean isUser(HttpSession session){
        if(session.getAttribute("user") != null){
            return true;
        }
        return false;
    }
}
