package main.model;

import java.util.Vector;

/**
 * Classe qui gere le chemin suivi par la balle en mode AUTOMATIQUE
 * @author PITROU Adrien
 * @version 1.0
 * @since 15/03/18
 * */
public class Path {
	
	private Vector<Pair<Integer, Integer>> points;//tableau de points
	private int iterator;//iterateur sur les points
	
	public Path(Vector<Pair<Integer, Integer>> tabPoints){
		 points = new Vector<Pair<Integer, Integer>>(tabPoints);//recupere les points
		 iterator = 0;
	}
	
	public void addPoint(int posX, int posY) {
		points.add(new Pair<Integer, Integer>(posX, posY));
	}
	
	/**
	 * Donne la prochaine direction
	 * @param posX la position en X courante
	 * @param posY la position en Y courante
	 * @return Pair<Integer, Integer> retour la prochaine direction a suivre.
	 * Le first correspond a dirX et le second a dirY
	 * */
	public Pair<Double, Double> getNextDir(int posX, int posY, int vitesse){
		assert(points != null);
		
		if(iterator >= points.size()-1) {//arret au bout du chemin
			return new Pair<Double, Double>(0.0, 0.0);
		}
		
		Pair<Double, Double> retour = null;//le retour qui correspondra a dirX, dirY
		
		Pair<Integer, Integer> p1 = points.get(iterator);//recuperation des deux points
		Pair<Integer, Integer> p2 = points.get(iterator + 1);
		
		double vectX = p2.first() - posX;
		double vectY = p2.second() - posY;
		double dist = Math.sqrt(Math.pow(vectX, 2)+Math.pow(vectY, 2));
		//double diviseur = dist / vitesse;
		
		double dirX = (double) Math.round((vitesse*vectX) / dist);
		double dirY = (double) Math.round((vitesse*vectY) / dist);
		
//		double compX = p2.first() - posX;
//		double compY = p2.second() - posY;
		
		System.out.println("dirX="+dirX + " dirY="+dirY);
		System.out.println("dist="+dist + " vectX="+vectX+" vectY="+vectY);
		
		//double minTest = Math.min(Math.abs(compX), Math.abs(compY));
		
		//changement de direction si on est proche du point d'arrivee
		if(Math.abs(vectX) <= Math.abs(dirX) &&
				Math.abs(vectY) <= Math.abs(dirY)) {
			System.out.println("--------------------------------------\n----------------\n");
			iterator ++;
			return new Pair<Double, Double>(vectX, vectY);
		}
		
		//vecteur-directeur
		retour = new Pair<Double, Double>(dirX,dirY);
		
		return retour;
	}

	public Vector<Pair<Integer, Integer>> getPoints() {
		return points;
	}
	
}
