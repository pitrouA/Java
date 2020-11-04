package main.view.menubar;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.model.Level;

public class MenuNiveau extends Menu{
	
	MenuNiveau(Level l){
		this.setText("Niveau");
		this.setGraphic(new ImageView(new Image("lv.png")));

		for(int i = 1; i< 7; i++) {//ajout des niveaux
			this.getItems().add(new MenuItemNiveau(l, i));
		}
	}
}
