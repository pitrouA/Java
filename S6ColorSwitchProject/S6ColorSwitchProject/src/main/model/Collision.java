package main.model;

import java.util.ArrayList;
import java.util.Vector;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import main.model.forms.Ball;
import main.model.forms.Doigt;
import main.model.forms.Form;

public class Collision {
	//;
	//private ;
	private Level l;

	public Level getL() {
		return l;
	}

	public Collision( Level l) {
		//balle=b;
		//formes=f;
		this.l= l;
	}

	public boolean inter(ArrayList<Shape> listeShape, Shape bal1){
		//pour chaque parties de la forme
		for(Shape sh:listeShape){
			//si collision on vérifie la couleur
			if(Shape.intersect(bal1, sh).getBoundsInLocal().getHeight()!=-1 && Shape.intersect(bal1, sh).getBoundsInLocal().getWidth()!=-1){
				//pas la meme couleur
				if(bal1.getFill()!=sh.getFill()){
					System.out.println("collision couleur");
					return true;
				}

				System.out.println("pas collision couleur");
			}
			//pas collision
			else{

				//System.out.println("pas collision");
			}
		}
		return false;
	}

	public boolean isCol(){
		Ball balle = l.getBall();
		//Doigt doi=l.getDoi();
		Vector<Form> formes = l.getObjects();
		ArrayList<Shape> listeShape;
		Shape bal1;

		for (Form it : formes){
			//on récupère les shapes de it
			listeShape=it.getShape();
			bal1=balle.getShape().get(0);
			//System.out.println(it.getClass());
//				if (!it.equals(balle) && !it.getClass().equals(Class.forName("main.model.forms.Etoile")) && !it.getClass().equals(Class.forName("main.model.forms.ChangeColor")) && !it.getClass().equals(Class.forName("main.model.forms.Road"))) {//pas la balle, le doigt, l'étoile et le changecouleur
//					//si collision
//					if(inter(listeShape,bal1)){
//						balle.setCouleur(ColorSelected.couleuralea());
//						return true;
//					}
//
//				} else if(it.getClass().equals(Class.forName("main.model.forms.Etoile"))){
//					//si collision avec etoile
//					if(inter(listeShape,bal1)){
//						System.out.println("score +1");
//					}
//				}
//				else if(it.getClass().equals(Class.forName("main.model.forms.ChangeColor"))){
//					//si collision avec changecolor
//					if(inter(listeShape,bal1)){
//						System.out.println("change couleur");
//						balle.setCouleur(ColorSelected.couleuralea());
//					}
//				}
//				else{
//					System.out.println("balle ou doigt ou road");    //no collision -same block
//				}
			if(inter(listeShape,bal1)){
				return it.doCollision(l);
			}
		}

		/*System.out.println("BALLEeeeeee "+balle.getBoundsInLocal());
		System.out.println("BALLE "+balle.getPosX());
		System.out.println("BALLE "+balle.getPosY());*/
		return false;

	}

}
