package main.view.menubar;

import javafx.scene.control.Menu;
import main.controler.Moteur;

public class MenuParametre extends Menu{
	Moteur m;
	public MenuParametre(Moteur m) {
		this.m = m;
		this.setText("Paramètres");
		this.getItems().add(new MenuItemSon(m));
		this.getItems().add(new MenuItemCouleur(m));
	}

}
