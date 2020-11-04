package main.model.forms;

import java.util.Vector;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import main.model.ColorSelected;
import main.model.Pair;
import main.model.Path;

/**
 * La balle du jeu
 * @author BARRECH Mehdi & PITROU Adrien
 * @version 1.0
 * @since 03/03/18
 * */
public class Ball extends Obstacles{
	private double dirX;
	private double dirY;
	private final int MAXV;
	private final int AMORTISSEMENT = 2;
	private int latence = 0;//temps de latence avant que la balle ne soit attiree par la gravite
	//private final int LIMITE = 3;
	private Circle circle;
	private Color couleur;
	private boolean isAuto = false;
	private Path chemin;
	
	Ball(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
		this.dirX = 0;
		this.dirY = 0;
		this.MAXV = speed;
		
		circle = new Circle();
		
        circle.setRadius(width);
        circle.setFill(ColorSelected.YELLOW);
        circle.setStroke(ColorSelected.YELLOW);
        circle.setStrokeWidth(1);
        this.setCouleur(ColorSelected.YELLOW);
        forme.getChildren().add(circle);
        Vector<Pair<Integer, Integer>> points = new Vector<Pair<Integer, Integer>>();
        //points.add(new Pair<Integer, Integer>(posX,posY));
		//points.add(new Pair<Integer, Integer>(30,30));
		//points.add(new Pair<Integer, Integer>(100,300));
		//points.add(new Pair<Integer, Integer>(300,200));
		//points.add(new Pair<Integer, Integer>(200,300));
		//points.add(new Pair<Integer, Integer>(500,100));
		//points.add(new Pair<Integer, Integer>(700,600));
        
        chemin = new Path(points);
	}

	@Override
	public void deplacer() {
		if(isAuto) {
			chdir();
		}
		this.setPosX((int) (this.getPosX() + dirX));//change la position selon le vecteur directeur
		this.setPosY((int) (this.getPosY() + dirY));
		this.getForme().setLayoutX(this.getPosX());//fait la translation
		this.getForme().setLayoutY(this.getPosY());
	}

	public void exploser(Explosion e){
		//final Rectangle rectangle2 = new Rectangle(this.getTranslateX(), this.getTranslateY(), 150, 100);
        //root.getChildren().add(rectangle2);
		//this.circle.setVisible(false);
		//e.seDeplacer(this);
		//for(Node n:e.getRec()){
		final KeyFrame kf2 = new KeyFrame(Duration.ZERO, new KeyValue(this.circle.translateXProperty(), 0));
        final KeyFrame kf12 = new KeyFrame(Duration.seconds(2), new KeyValue(this.circle.translateXProperty(), 50));
        final Timeline timeline2 = new Timeline(kf2, kf12);
        timeline2.playFromStart();
		//}
        //timeline2.setCycleCount(Timeline.INDEFINITE);
        System.out.println("exploser");
        //timeline2.setAutoReverse(true);
	}
	
	public void gravityY(int gravityY){
		if(latence > 0) {
			latence --;
		}else if(gravityY < 0) {//gravite vers le bas
			if(dirY > -MAXV){
				dirY -= AMORTISSEMENT;
			}
		}else if(gravityY > 0) {//gravite vers le haut
			if(dirY < MAXV){
				dirY += AMORTISSEMENT;
			}
		}else{
			if(dirY > 0){//arret de la gravite
				dirY -= AMORTISSEMENT;
			}else if(dirY < 0){
				dirY += AMORTISSEMENT;
			}
		}
	}
	
	public void maxY() {
		dirY = -(MAXV);
		latence = 3;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
		circle.setFill(couleur);
	}

	@Override
	public String toString() {
		return "Ball [dirX=" + dirX + ", dirY=" + dirY + ", MAXV=" + MAXV + ", AMORTISSEMENT=" + AMORTISSEMENT
				+ ", posX=" + posX + ", posY=" + posY + ", width=" + width + ", height=" + height + ", speed=" + speed
				+ ", forme=" + forme + ", rotation=" + rotation + "]";
	}

	public void start() {
		//maxY();
		isAuto = true;
	}
	
	private void chdir() {
		Pair<Double, Double> coordonnees = chemin.getNextDir(posX, posY, speed);
		dirX = coordonnees.first();
		dirY = coordonnees.second();
	}

	public void addPoint(int posX, int posY) {
		chemin.addPoint(posX, posY);
	}

	public Vector<Pair<Integer, Integer>> getPoints() {
		return chemin.getPoints();
	}
	
	public void repercuterDefilementX(int defilement) {
		Vector<Pair<Integer, Integer>> points = chemin.getPoints();
		for(Pair<Integer, Integer> point : points) {
			point.setFirst(point.first()+defilement);
		}
	}
	
	public void repercuterDefilementY(int defilement) {
		Vector<Pair<Integer, Integer>> points = chemin.getPoints();
		for(Pair<Integer, Integer> point : points) {
			point.setSecond(point.second()+defilement);
		}
	}
}
