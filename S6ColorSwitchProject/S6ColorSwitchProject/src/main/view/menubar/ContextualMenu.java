package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.KeyEvent;
import javafx.stage.WindowEvent;
import main.controler.ControlerFactory;
import main.controler.Moteur;

public class ContextualMenu extends ContextMenu{
	Moteur m;
	
	public ContextualMenu(Moteur m){
		this.m = m;
		this.getItems().add(new MenuItemQuitter());
		this.addEventHandler(WindowEvent.WINDOW_SHOWING, 
        		ControlerFactory.build(WindowEvent.WINDOW_SHOWING,null, m));
		this.addEventHandler(WindowEvent.WINDOW_HIDING, 
        		ControlerFactory.build(WindowEvent.WINDOW_HIDING,null, m));
	}
}
