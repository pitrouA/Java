package main.view.menubar;

import java.io.File;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.Level;

public class MenuItemSon extends MenuItem implements Action{
	Moteur m;
	private boolean son=true;
	final File file = new File("src/ressources/music.wav");
    final Media media = new Media(file.toURI().toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
	/*final URL musicURL = getClass().getResource("music.mp3");
	final  Media media = new Media(musicURL.toExternalForm());
	final MediaPlayer mediaPlayer = new MediaPlayer(media);*/
	final Image imon=new Image("son_on.png");
	final int large=(int) imon.getHeight();
	final ImageView iv=new ImageView(imon);
	final Image imoff=new Image("son_off.png");
	final int large2=(int) imoff.getHeight();
	final ImageView iv2=new ImageView(imoff);
	MenuItemSon(Moteur m){

		iv.setFitHeight(large/2);
		iv.setPreserveRatio(true);
		iv2.setFitHeight(large2/2);
		iv2.setPreserveRatio(true);
		this.setGraphic(iv);
		this.m = m;
		this.setText("Son");
		this.setAccelerator(KeyCombination.keyCombination("w"));
		System.out.println(media);
		mediaPlayer.setOnRepeat(null);
		mediaPlayer.play();
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, null, null));
	}

	public void changerSon(){

		if(son){
			//couper
			this.setGraphic(iv2);
			son=false;
			mediaPlayer.stop();
		}
		else{
			//allumer
	        mediaPlayer.play();
			this.setGraphic(iv);
			son=true;
		}
	}

	@Override
	public void action(Level level) {
		System.out.println("son menu");
		this.changerSon();
	}
}
