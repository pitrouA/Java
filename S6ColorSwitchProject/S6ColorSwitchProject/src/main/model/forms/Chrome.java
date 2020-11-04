package main.model.forms;

import java.util.Vector;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import main.model.Level;
import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Cercle chromatique pour le mode AUTOMATIQUE
 * @author PITROU Adrien
 * @version 1.0
 * @since 18/03/18
 * */
public class Chrome extends Form{

	Chrome(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}
	
	public void rotateChromeLeft() {
		Node aTourner = forme.getChildren().get(0);
		aTourner.setRotate((aTourner.getRotate()+90)%360);
	}
	
	public void rotateChromeRight() {
		Node aTourner = forme.getChildren().get(0);
		aTourner.setRotate((aTourner.getRotate()-90)%360);
	}
	
	public void createChrome(Vector<Color> colorPossible) {
		
		final double angle = 360 / colorPossible.size();
		short anglePrecedent = 45;
		
		Group aTourner = new Group();
		
		for(Color couleur : colorPossible) {
			Arc arc = new Arc();
			arc.setFill(Color.TRANSPARENT);
	        arc.setRadiusX(30);
	        arc.setRadiusY(30);
	        arc.setLayoutX(posX);
	        arc.setLayoutY(posY);
	        arc.setStartAngle(anglePrecedent);
	        arc.setLength(angle);
	        arc.setStroke(couleur);
	        arc.setStrokeWidth(5);
	        arc.setType(ArcType.OPEN);//round, open, chord
	        aTourner.getChildren().add(arc);
	        anglePrecedent += angle;//deplacement du point de depart
		}
		
		double s1X =  0;
	    double s1Y = 0;
	    double s2X = 20;
	    double s2Y = 0;
	    double s3X = 10;
	    double s3Y = -20;
	        
	    Polygon triangle = new Polygon();
	    triangle.getPoints().addAll(s1X,s1Y,s2X,s2Y,s3X,s3Y);
	 	triangle.setFill(Color.GREY);
	 	triangle.setLayoutX(posX);
	 	triangle.setLayoutY(posY);
	 	triangle.setTranslateX(-10);
	 	triangle.setTranslateY(10);
	 	triangle.setStrokeWidth(3);
	 	triangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
	 	triangle.setStroke(Color.GREY);
		
	 	forme.getChildren().add(aTourner);
	 	forme.getChildren().add(triangle);
	}

	@Override
	public boolean doCollision(Level level) {
		return false;//jamais de collision
	}
}
