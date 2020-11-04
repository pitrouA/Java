package main.controler;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import main.view.menubar.MenuItemVitesse;

class EcouteurFenetreOuverte implements EventHandler<WindowEvent>{
	Moteur m;
	
	EcouteurFenetreOuverte(Moteur m){
		this.m = m;
	}
	
	@Override
	public void handle(WindowEvent evt) {
		m.cancel();
	}
	
}
