package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.model.Level;

class ActionNouvellePartie implements EventHandler<MouseEvent>{
    Level level;
	
    ActionNouvellePartie(Level level){
    	this.level = level;
    }
    
    @Override
    public void handle(MouseEvent t) {
        System.out.println("action np");
        level.nouvellePartie("niveau4");
        //level.update();
    }
}
