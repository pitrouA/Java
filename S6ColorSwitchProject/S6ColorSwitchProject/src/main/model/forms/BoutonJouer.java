package main.model.forms;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;

public class BoutonJouer extends ObstacleRound1{

	BoutonJouer(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		
		forme.getChildren().remove(1);//suppression de l'etoile
		
		double s1X =  0;
	    double s1Y = 0;
	    double s2X = 20;
	    double s2Y = 10;
	    double s3X = 0;
	    double s3Y = 20;
	        
	    Polygon triangle = new Polygon();
	    triangle.getPoints().addAll(s1X,s1Y,s2X,s2Y,s3X,s3Y);
	 	triangle.setFill(Color.GREY);
	 	triangle.setTranslateX(-10);
	 	triangle.setTranslateY(-10);
	 	triangle.setStrokeWidth(3);
	 	triangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
	 	triangle.setStroke(Color.GREY);
		
	 	forme.getChildren().add(triangle);
	}

}
