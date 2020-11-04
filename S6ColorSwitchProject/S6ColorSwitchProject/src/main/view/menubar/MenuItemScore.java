package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.Level;

public class MenuItemScore extends MenuItem implements Action{
	
	MenuItemScore(Level l){
		this.setText("Score");
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION,  l, null));
	}
	
	@Override
	public void action(Level level) {
		new DialogScores(level);
	}
}
