package main.model.forms;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import main.model.Level;

public class MessageScore extends Form{
	private Label l;

	MessageScore(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		l = new Label("0");
		l.setFont(new Font(width));
		l.setTextFill(WHITE);
		
		ajouterForme(l);
		forme.setLayoutX(posX);
		forme.setLayoutY(posY);
	}
	
	public void updateScore(int score) {
		l.setText(""+score);
	}

	@Override
	public void deplacer() {
		//ne bouge pas
	}

	@Override
	public boolean doCollision(Level level) {
		return false;//jamais de collisions
	}
}
