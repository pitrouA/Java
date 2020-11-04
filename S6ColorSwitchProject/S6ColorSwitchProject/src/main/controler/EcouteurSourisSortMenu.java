package main.controler;

import javafx.event.EventHandler;
import javafx.util.Duration;
import main.model.Level;
import javafx.application.Platform;
import javafx.event.Event;

class EcouteurSourisSortMenu implements EventHandler<Event> {
	Moteur m;
	Level l;
	
	EcouteurSourisSortMenu(Moteur m, Level l){
		this.m = m;
		this.l = l;
	}

	@Override
	public void handle(Event evt) {
		//if(!l.isPerdu()) {
		if(l.getBall() != null) {
			l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
			l.gravityDown();
		}
		m.restart();
	}
}
