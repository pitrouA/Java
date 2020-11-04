package main.view.menubar;

import javafx.scene.control.Menu;
import main.controler.Moteur;
import main.model.Level;

public class MenuHelp extends Menu{
	Moteur m;
	
	MenuHelp(Moteur m, Level l){
		this.m = m;
		this.setText("Help");
		this.getItems().add(new MenuItemHelp());
		
	}
}
