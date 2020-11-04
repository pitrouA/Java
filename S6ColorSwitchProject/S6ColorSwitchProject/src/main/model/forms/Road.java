package main.model.forms;

import java.util.Vector;

import javafx.scene.shape.Polyline;
import javafx.scene.shape.StrokeLineJoin;
import main.model.Level;
import main.model.Pair;

public class Road extends Form{

	public Road(int posX, int posY, int width, int height, int speed, int rotate) {
		super(posX, posY, width, height, speed, rotate);
	}
	
	public void createRoad(Vector<Pair<Integer, Integer>> points) {
		Polyline road = new Polyline();
		road.setStrokeLineJoin(StrokeLineJoin.ROUND);
		for(Pair<Integer, Integer> point : points) {
			road.getPoints().addAll((double)point.first(), (double)point.second());
		}
		//road.setRotate(180);
		ajouterForme(road);
	}

	@Override
	public void deplacer() {
		//ne se deplace pas
	}

	@Override
	public boolean doCollision(Level level) {
		return false;//jamais de collisions
	}
}
