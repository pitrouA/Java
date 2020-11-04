package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import main.model.Level;

class EcouteurToucheRelachee implements EventHandler<KeyEvent>{
	private Level l;
	
	EcouteurToucheRelachee(Level l){
		this.l = l;
	}
	
    @Override
    public void handle(KeyEvent evt) {
        
    }
}

