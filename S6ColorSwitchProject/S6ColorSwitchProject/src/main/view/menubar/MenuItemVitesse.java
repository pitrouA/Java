package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.Level;

public class MenuItemVitesse extends MenuItem implements Action{
	Moteur m;
	int vitesse;
	
	MenuItemVitesse(Moteur m, int vitesse){
		this.m = m;
		this.vitesse = vitesse;
		this.setText("Mode "+vitesse);
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	public int getVitesse() {
		return vitesse;
	}
	
	@Override
	public void action(Level level) {
		System.out.println("Vitesse "+this.getVitesse());
	}
}
