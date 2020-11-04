package main.view.menubar;

import javafx.scene.control.Dialog;
import javafx.scene.*;
import javafx.scene.control.Label;

public class DialogHelp extends Dialog<Scene>{
	public DialogHelp(){
		this.setGraphic(new Label("Projet realise par PITROU Adrien, CALVO-FERNANDEZ Adelie et BARRECH Mehdi"));
		this.setWidth(200);
		this.setHeight(200);
		this.setTitle("Ma boite");
		this.show();
	}
}
