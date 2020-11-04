package main.controler;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import main.model.Level;
import main.model.Type;

/**
 * Ecoute les touches du clavier
 * @author PITROU Adrien
 * @version 1.0
 * @since 02/03/18
 * */
class EcouteurToucheEnfoncee implements EventHandler<KeyEvent>{
	private Level l;
	
	EcouteurToucheEnfoncee(Level l){
		this.l = l;
	}
	
    @Override
    public void handle(KeyEvent evt) {
        String touche = evt.getText();
        
        if(l.getBall() == null) {//pas d' action de clavier sans balle
        	return;
        }
       
        if(touche.equals("n")){
        	if(l.getType() == Type.AUTOMATIQUE) {
        		l.getBall().start();
        		l.getBall().setCouleur(l.getNextColor());//change la couleur de la balle
        		l.getChrome().rotateChromeLeft();
        	}else {
        		l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
            	l.gravityDown();
        	}
        }
        
        if(touche.equals("b")) {
        	if(l.getType() == Type.AUTOMATIQUE) {
        		l.getBall().start();
        		l.getBall().setCouleur(l.getPreviewsColor());//change la couleur de la balle
        		l.getChrome().rotateChromeRight();
        	}else {
        		l.getBall().maxY();//donne l'impression de "donner un coup dans la balle"
            	l.gravityDown();
        	}
        }
    }
}
