package main.controler;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import main.model.Collision;
import main.model.Level;
import main.model.Type;
import main.view.Fenetre;

/**
 * Classe-moteur de l'application. Gere une tache d'arriere plan qui s'occupera
 * de deplacer la balle, les obstacles et lancer les tests de collision entre
 * objets.
 * Cette classe a une forte interdependance avec la fenetre principale qu' elle
 * va raffraichir sans arret.
 * @author PITROU Adrien
 * @version 1.0
 * @since 23/02/18
 * */
public class Moteur extends Service<Object>{
	private Fenetre f;
	private Task<Object> t;
	private Collision col;
	
	/**
	 * Constructeur du moteur.
	 * @param Fenetre f la fenetre avec qui communiquer
	 * */
	public Moteur(Fenetre f) {
		assert(f != null);
		
		col=new Collision(f.getLevel());
		this.f = f;
	}
	
	/**
	 * Deplace la balle ou fait defiler l'ecran. Gere aussi l'attraction de la balle.
	 * */
	private void deplacerBall() {
		assert(f.getLevel() != null);
		
		Level l = f.getLevel();
		
		if(l.getBall() == null ) {
			return;
		}
		
		if(l.getType() == Type.AUTOMATIQUE) {
			if( l.getBall().getPosY()<f.getHauteurFenetre()*1/5) {//defilement vers le haut
				f.defilerEcranY(false);
			}
			if( l.getBall().getPosY()>f.getHauteurFenetre()*4/5) {//defilement vers le bas
				f.defilerEcranY(true);
			}
			if( l.getBall().getPosX()<f.getLargeurFenetre()*1/5) {//defilement vers la gauche
				f.defilerEcranX(true);
			}
			if( l.getBall().getPosX()>f.getLargeurFenetre()*4/5) {//defilement vers la droite
				f.defilerEcranX(false);
			}
		}else if(l.getType() == Type.INVERSE){
			if( l.getBall().getPosY()>f.getHauteurFenetre()*3/5) {//defilement vers le haut
				f.defilerEcranY(true);
			}
		}else {
			if( l.getBall().getPosY()<f.getHauteurFenetre()*2/5) {//defilement vers le haut
				f.defilerEcranY(false);
			}
		}
		
		if(l.getType() == Type.AUTOMATIQUE) {//mode automatique -> deplacement automatique
			l.getBall().deplacer();
		}else {
			l.getBall().deplacer();
			l.getBall().gravityY(l.gravityY());//la balle tombe selon la gravite
		}
	}
	
	/**
	 * Renvoie true si le niveau est perdu
	 * */
	public boolean isPerdu() {
		assert(f.getLevel() != null);
		
		Level l = f.getLevel();
		
		if(l.getBall() == null) {//pour le menu principal -> pas de balle
			return false;
		}
		if(l.getType() == Type.INVERSE) {
			return l.getBall().getPosY()<50;//en haut de l'ecran
		}else {
			return l.getBall().getPosY()>f.getHauteurFenetre()-50;//en bas de l'ecran
		}
	}

    @Override
    protected Task<Object> createTask() {
    	t = new MaTask();
    	return t;
    }
    
    /**
     * Classe interne qui gere l'ensemble des actions realisees par la tâche.
     * */
    private class MaTask extends Task<Object>{

		@Override
		protected Object call() throws Exception {
			try {
				System.out.println("call");
				while(true) {
					synchronized(this) {
						Thread.sleep(50);
						Level l = f.getLevel();
						for(int i=0;i<l.getObjects().size();i++) {//a jouer aussi pour le menu
							l.getObjects().get(i).deplacer();//deplace chaque forme
						}
						if(l.getBall() == null) {//si on est dans les menus, inutile de deplacer la balle
							continue;
						}
						if(col.isCol()) {
							f.getLevel().getBall().exploser(f.getLevel().getExplo());
							Thread.sleep(3000);
							f.getLevel().perdu();//fait perdre le niveau
							f.menu();
							return f;
						}
						if(isPerdu()) {//teste la defaite
							f.getLevel().perdu();//fait perdre le niveau
							f.menu();
							return f;
						}else {
							deplacerBall();//deplace la balle ou fait defiler l'ecran
						}//else
					}//synchronized
				}//while
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
//			catch(Exception e){//try
//				e.printStackTrace();
//			}
			return null;
		}//call
    }//MaTask
	
}
