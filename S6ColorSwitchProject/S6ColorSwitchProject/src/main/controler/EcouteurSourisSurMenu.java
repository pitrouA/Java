package main.controler;

import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.event.Event;

class EcouteurSourisSurMenu implements EventHandler<Event> {
	Moteur m;
	
	EcouteurSourisSurMenu(Moteur m){
		this.m = m;
	}

	@Override
	public void handle(Event evt) {
		m.cancel();
	}
}
