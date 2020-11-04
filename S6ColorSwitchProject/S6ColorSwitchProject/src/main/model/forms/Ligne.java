package main.model.forms;

import java.util.Arrays;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Ligne extends Obstacles{
	
	private Color[] colorPossible;
	private static short compteurCouleur;
	
	Ligne(int posX, int posY, int width, int height, int speed, int rotate){
		super(posX, posY, width, height, speed, rotate);
                
                final double TAILLE_RECTANGLE = width / 4;
                double posPart = posX - ((3*width)/2);
                colorPossible = new Color[4];
                colorPossible[0] = YELLOW;
                colorPossible[1] = BLUE;
                colorPossible[2] = PURPLE;
                colorPossible[3] = ROSE;
                compteurCouleur = 0;
		
                for(int i=0;i<8;i++){
                    Rectangle part1 = new Rectangle();
                    part1.setWidth(TAILLE_RECTANGLE);
                    part1.setHeight(height);
                    part1.setLayoutX(posPart);
                    //part1.setLayoutY(posY-(2*height));
                    part1.setFill(getNextColor());
                    
                    posPart += TAILLE_RECTANGLE;
                    
                    ajouterForme(part1);
                }
	}
	
	/**
	 * Renvoie la prochaine couleur possible
	 * @return Color la prochaine couleur possible
	 * */
	private Color getNextColor() {
		compteurCouleur ++;
		if(compteurCouleur >= colorPossible.length) {//circulaire
			compteurCouleur = 0;
		}
		return colorPossible[compteurCouleur];
	}

	@Override
	public void deplacer() {
		for(Node part : forme.getChildren()) {
			part.setLayoutX(part.getLayoutX() + speed);//deplace a droite
			if(part.getLayoutX() > width) {//teleporte arrive au bout
				part.setLayoutX(-width);
			}
		}
	}

	@Override
	public String toString() {
		return "Ligne [colorPossible=" + Arrays.toString(colorPossible) + ", posX=" + posX + ", posY=" + posY
				+ ", width=" + width + ", height=" + height + ", speed=" + speed + ", rotation=" + rotation + "]";
	}
}
