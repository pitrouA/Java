package main.controler;

import javafx.stage.WindowEvent;
import main.view.menubar.DialogHelp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;

class EcouteurDialogOuvert implements EventHandler<DialogEvent>{
	
	EcouteurDialogOuvert(){}
	
	@Override
	public void handle(DialogEvent evt) {
    	new DialogHelp();//j' en suis la
	}
	
}
