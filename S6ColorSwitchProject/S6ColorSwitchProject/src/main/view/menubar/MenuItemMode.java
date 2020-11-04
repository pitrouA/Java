package main.view.menubar;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import main.controler.ControlerFactory;
import main.model.Level;
import main.model.Type;

public class MenuItemMode extends MenuItem implements Action{
	Type modeType;
	
	MenuItemMode(Level l, int mode){
		switch(mode) {
		case 1:modeType = Type.INVERSE;break;
		case 2:modeType = Type.DEUX_AXES;break;
		case 3:modeType = Type.AUTOMATIQUE;break;
		case 4:modeType = Type.IA;break;
		default:modeType = Type.NORMAL;
		}
		this.setText("Mode "+modeType.name());
		this.addEventHandler(ActionEvent.ACTION,
        		ControlerFactory.build(ActionEvent.ACTION, l, null));
	}
	
	public Type getType() {
		return modeType;
	}

	@Override
	public void action(Level level) {
		System.out.println("Mode "+this.getType().name());
	}
}
