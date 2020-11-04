package main.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.model.Level;
import main.view.menubar.Action;

class ActionBouton implements EventHandler<ActionEvent>{
	Moteur m;
	Level l;

	ActionBouton(Moteur m, Level l){
		this.m = m;
		this.l = l;
	}

    @Override
    public void handle(ActionEvent t) {
    	Action item = (Action) t.getTarget();
    	item.action(l);
    }
}
