package main.controler;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.event.Event;
import main.model.Level;

public class EcouteurFenetreRetaillee implements EventHandler<Event>{
	Level l;
	
	EcouteurFenetreRetaillee(Level l){
		this.l = l;
	}
	
	@Override
	public void handle(Event evt) {
		l.retaillerObjets();
	}

}
