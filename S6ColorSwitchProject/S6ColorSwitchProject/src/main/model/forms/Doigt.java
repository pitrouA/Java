package main.model.forms;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import main.model.Level;

/**
 * Le doigt qui retient la balle
 * @author PITROU Adrien
 * @version 1.0
 * @since 12/03/18
 * */
public class Doigt extends Form{

	public Doigt(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);

        double s1X = 50;
        double s1Y = 20;

        double s2X = 40;
        double s2Y = 30;

        //Line l1=new Line(s1X, s1Y, s2X, s2Y);

//        double s3X = 0;
//        double s3Y = 17;

        //Line l2=new Line(s2X, s2Y, s3X, s3Y);

        double s4X = 35;
        double s4Y = 25;

        //Line l3=new Line(s3X, s3Y, s4X, s4Y);

        double s5X = 35;
        double s5Y = 50;
        
        double s6X = 25;
        double s6Y = 50;
        
        double s7X = 25;
        double s7Y = 34;
        
        double s8X = 18;
        double s8Y = 32;
        
        double s9X = 10;
        double s9Y = 30;
        
        double s10X = 0;
        double s10Y = 30;
        
        double s11X = 0;
        double s11Y = 0;
        
        double s12X = 30;
        double s12Y = 0;

        //Line l4=new Line(s4X, s4Y, s5X, s5Y);

        //Line l5=new Line(s5X, s5Y, s1X, s1Y);
        Polygon doigt = new Polygon();
        doigt.getPoints().addAll(s1X,s1Y,s2X,s2Y,s4X,s4Y,s5X,s5Y
				,s6X,s6Y,s7X,s7Y,s8X,s8Y,s9X,s9Y,s10X,s10Y,s11X,s11Y,s12X,s12Y);
        doigt.setFill(WHITE);
        doigt.setStrokeWidth(3);
        doigt.setStrokeLineJoin(StrokeLineJoin.ROUND);
        doigt.setStroke(WHITE);
        doigt.setScaleX(width / 50);//mise a l'echelle
        doigt.setScaleY(height / 50);
        doigt.setLayoutX(-width/2);
        doigt.setLayoutY(-width/2);
		//etoile.setStrokeLineCap(StrokeLineCap.ROUND);
		forme.setRotate(180);
		ajouterForme(doigt);
	}

	@Override
	public void deplacer() {
		//ne bouge pas
	}

	@Override
	public String toString() {
		return "Doigt [posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	@Override
	public boolean doCollision(Level level) {
		level.gravityYStop();//le doigt arrete la balle
		return false;
	}
}
