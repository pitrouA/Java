package main.controler;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import main.view.menubar.MenuItemVitesse;

class EcouteurFenetreFermee implements EventHandler<WindowEvent>{
	Moteur m;
	
	EcouteurFenetreFermee(Moteur m){
		this.m = m;
	}
	
	@Override
	public void handle(WindowEvent evt) {
		m.restart();
	}
	
}
