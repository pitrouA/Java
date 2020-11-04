package main.view.menubar;




import java.io.File;
import java.net.URL;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import main.controler.ControlerFactory;
import main.model.Level;

public class MenuItemHelp extends MenuItem implements Action{

	MenuItemHelp(){
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+h"));
		this.setGraphic(new ImageView(new Image("help.png")));

		//final URL imageURL = getClass().getResource("help.png");
		//final Image image = new Image(imageURL.toString());
		//ImageView imageView = new ImageView();
		//imageView.setImage(image);
        //final ImageView imageView = new ImageView(imageURL);
		//Image im=new Image("help.png");
		//this.setGraphic(imageView);

		this.setText("Help");
		this.addEventHandler(DialogEvent.DIALOG_SHOWING,
        		ControlerFactory.build(DialogEvent.DIALOG_SHOWING, null, null));
	}

	@Override
	public void action(Level level) {
		new DialogHelp();//j' en suis la
	}

	/*private class actionBouton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent t) {
        	System.out.println("Bonjour");
        	
        }
	}*/
}
