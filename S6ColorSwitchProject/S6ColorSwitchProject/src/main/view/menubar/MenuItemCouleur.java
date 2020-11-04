package main.view.menubar;

import java.io.File;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Level;

public class MenuItemCouleur extends MenuItem implements Action{
	Moteur m;
	ColorPicker colorPicker1 = new ColorPicker(ColorSelected.BLUE);
	ColorPicker colorPicker2 = new ColorPicker(ColorSelected.ROSE);
	ColorPicker colorPicker3 = new ColorPicker(ColorSelected.YELLOW);
	ColorPicker colorPicker4 = new ColorPicker(ColorSelected.PURPLE);

    final VBox root = new VBox();
    final HBox hb1= new HBox();
    final HBox hb2= new HBox();
    final HBox hb3= new HBox();
    final HBox hb4= new HBox();

    Stage primaryStage = new Stage();
    Button button1=null;

    Label lab1= new Label("Couleur 1");
    Label lab2= new Label("Couleur 2");
    Label lab3= new Label("Couleur 3");
    Label lab4= new Label("Couleur 4");

	MenuItemCouleur(Moteur m){
		root.setSpacing(20);

		hb1.setTranslateY(10);

		hb1.setTranslateX(10);
		hb2.setTranslateX(10);
		hb3.setTranslateX(10);
		hb4.setTranslateX(10);

		hb1.setSpacing(10);
		hb2.setSpacing(10);
		hb3.setSpacing(10);
		hb4.setSpacing(10);
		this.setText("Couleur");
        button1 = new Button("OK");
		button1.setTranslateX(70);;
        lab1.setLabelFor(colorPicker1);
        lab2.setLabelFor(colorPicker2);
        lab3.setLabelFor(colorPicker3);
        lab4.setLabelFor(colorPicker4);


        hb1.getChildren().add(lab1);
        hb1.getChildren().add(colorPicker1);
        hb2.getChildren().add(lab2);
        hb2.getChildren().add(colorPicker2);
        hb3.getChildren().add(lab3);
        hb3.getChildren().add(colorPicker3);
        hb4.getChildren().add(lab4);
        hb4.getChildren().add(colorPicker4);

        root.getChildren().add(hb1);
        root.getChildren().add(hb2);
        root.getChildren().add(hb3);
        root.getChildren().add(hb4);

        root.getChildren().add(button1);

        final Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("sélecteur de couleurs");
        primaryStage.setScene(scene);
		this.addEventHandler(ActionEvent.ACTION,
        ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	public void changerCouleur(){
        primaryStage.show();
	}

	@Override
	public void action(Level level) {
		button1.setOnAction(new EventHandler<ActionEvent>() {

		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	ColorSelected.BLUE=colorPicker1.getValue();
		    	ColorSelected.ROSE=colorPicker2.getValue();
		    	ColorSelected.YELLOW=colorPicker3.getValue();
		    	ColorSelected.PURPLE=colorPicker4.getValue();
		    	primaryStage.close();
		    }
		});
		this.changerCouleur();
	}
}
