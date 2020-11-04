package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

class ActionVide implements EventHandler<MouseEvent>{
    
    ActionVide(){}
    
    @Override
    public void handle(MouseEvent t) {
        System.out.println("action vide");
    }
}
