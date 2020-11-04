package main.view.menubar;

import javafx.scene.control.Menu;
import main.model.Level;

public class MenuModes extends Menu{

	MenuModes(Level l){
		this.setText("Modes de jeu");
		for(int i=0;i<5;i++) {
			this.getItems().add(new MenuItemMode(l, i));
		}
	}
}
