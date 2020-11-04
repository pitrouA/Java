package main.model.forms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import main.model.Level;

class MessageColorSwitch extends Form{
	
	Set<Form> parties = new HashSet<Form>();
	
	MessageColorSwitch(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		final int PARTX = width / 5;
		final int PARTY = height / 2;
		
		Label labC = new Label("C");
		labC.setFont(new Font(PARTY/2));
		labC.setTextFill(BLUE);
		labC.setPrefWidth(PARTX);
		labC.setPrefHeight(PARTY);
		
		Round1 round1 = new Round1(0, 0, PARTX, PARTX, speed, rotate);
		round1.getForme().setTranslateX(1.5*PARTX);
		round1.getForme().setTranslateY(PARTY/2);
		
		Label labL = new Label("l");
		labL.setTranslateX(2*PARTX);
		//lab2.setTranslateY(posY);
		labL.setPrefWidth(PARTX);
		labL.setPrefHeight(PARTY);
		labL.setFont(new Font(PARTY/2));
		labL.setTextFill(BLUE);
		
		Round1 round2 = new Round1(0, 0, PARTX, PARTX, speed, rotate);
		round2.getForme().setTranslateX(3*PARTX);
		round2.getForme().setTranslateY(PARTY/2);
		
		Label labR = new Label("r");
		labR.setTranslateX(4*PARTX);
		//lab2.setTranslateY(posY);
		labR.setPrefWidth(PARTX);
		labR.setPrefHeight(PARTY);
		labR.setFont(new Font(PARTY/2));
		labR.setTextFill(BLUE);
		
		Label labSwitch = new Label("Switch");
		//labSwitch.setTranslateX(PARTX);
		labSwitch.setTranslateY(PARTY);
		labSwitch.setFont(new Font(PARTY/2));
		labSwitch.setTextFill(BLUE);
		labSwitch.setPrefWidth(width);
		labSwitch.setPrefHeight(PARTY);
		
		parties.add(round1);
		parties.add(round2);
		
		ajouterForme(labC);
		ajouterForme(round1.getForme());
		ajouterForme(labL);
		ajouterForme(round2.getForme());
		ajouterForme(labR);
		ajouterForme(labSwitch);
	}

	@Override
	public void deplacer() {
		Iterator<Form> it = parties.iterator();
		while(it.hasNext()) {
			it.next().deplacer();
		}
	}

	@Override
	public String toString() {
		return "MessageColorSwitch [parties=" + parties + ", posX=" + posX + ", posY=" + posY + ", width=" + width
				+ ", height=" + height + ", speed=" + speed + ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	@Override
	public boolean doCollision(Level level) {
		return false;// jamais de collisions
	}
	
}
