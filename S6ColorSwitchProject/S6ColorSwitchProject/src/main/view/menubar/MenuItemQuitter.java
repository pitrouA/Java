package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import main.controler.ControlerFactory;
import main.model.Level;

public class MenuItemQuitter extends MenuItem implements Action{

	@SuppressWarnings("unchecked") //le retour est correct mais il ne le sait pas
	MenuItemQuitter(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+q"));

		this.setGraphic(new ImageView(new Image("save.png")));

		this.setText("Quitter");
		
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	@Override
	public void action(Level level) {
		System.exit(0);
	}
	
}
