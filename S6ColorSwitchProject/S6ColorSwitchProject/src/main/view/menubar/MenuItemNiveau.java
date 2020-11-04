package main.view.menubar;

import javafx.event.ActionEvent;
import main.controler.ControlerFactory;
import main.model.Level;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class MenuItemNiveau extends MenuItem implements Action{
	int num;
	
	MenuItemNiveau(Level l, int num){
		this.num = num;
		this.setText("Niveau "+num);
//		if(num == 1) {//assuprimer
//			this.setAccelerator(KeyCombination.keyCombination("Ctrl+b"));
//		}
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+"+(char)('a' + num)));
		
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l));
	}
	
	public int getNum() {
		return num;
	}

	@Override
	public void action(Level level) {
		System.out.println("Changement de niveau : "+this.getNum());
		level.nouvellePartie("niveau"+this.getNum());
		//level.update();
	}
}
