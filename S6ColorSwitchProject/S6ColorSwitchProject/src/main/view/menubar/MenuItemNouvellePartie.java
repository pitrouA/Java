package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Level;
import javafx.scene.layout.VBox;

public class MenuItemNouvellePartie extends MenuItem implements Action{
	Level l;

	MenuItemNouvellePartie(Level l){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));

		this.setGraphic(new ImageView(new Image("save.png")));
		this.l = l;
		this.setText("Nouvelle Partie");

		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l, null));
	}

	@Override
	public void action(Level level) {
		System.out.println("Nouvelle partie");
		l.nouvellePartie("niveau"+l.getNumber());
		//l.update();
	}
}
