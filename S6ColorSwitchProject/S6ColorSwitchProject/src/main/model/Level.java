package main.model;

import java.util.Observable;
import java.util.Vector;

import main.model.forms.Ball;
import main.model.forms.Chrome;
import main.model.forms.Explosion;
import main.model.forms.Form;
import main.model.forms.FormsFactory;
import main.model.forms.Road;
import main.view.Fenetre;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * Classe qui se prend en charge tout les objets et parametres d'un niveau :
 * balle, obstacles, nom, points, scores, gravite ...
 * @version 1.0
 * @author PITROU Adrien
 * @since 31/01/2018
 * */
public class Level{
	private final int TAILLE_ENTETE = 6;
	private Score score;
	private Vector<Form> objects;//les obstacles du niveau
	private Vector<Form> objectsPossible;//les obstacles possibles du niveau
	private Ball ball;
	private String name;
	private int number;
	private Type type;
	private int points;
	private int gravityX, gravityY;//sens de gravite
	private Fenetre fenetre;//reference vers la vue
	private int coordinateX, coordinateY;//distance de la balle a l'origine
	Observable obs = new Observable();
	//private boolean perdu;
	private Explosion explo;
	private double scaleX = 0;
	private double scaleY = 0;
	private double transX = 0;
	private double transY = 0;
	private Vector<Color> colorPossible;
	private static short colorIterator;
	private Chrome chrome;
//	private Doigt doi;
//
//	public Doigt getDoi() {
//		return doi;
//	}
	
	/**
	 * Constructeur par defaut
	 * */
	public Level() {
		name = "niveau 1";
		score = new Score(6);
		ball = null;
		score.add("Bob", 23);//assuprimer
		score.add("Adrien", 230);
		score.add("Anne", 140);
		objects = new Vector<Form>();
		objectsPossible = new Vector<Form>();
		number = 0;
		points = 0;
		gravityX = 0;//pas de gravite
		gravityY = 0;//pas de gravite
		type = Type.NORMAL;
		setCoordinateX(setCoordinateY(0));
		//perdu = false;
		colorPossible = new Vector<Color>();
		colorIterator = 0;
	}
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y width height vitesse rotate
	 * */
	public Level(Fenetre fenetre){
		this();
		assert(fenetre != null);
		
		this.fenetre = fenetre;
		obs.addObserver(fenetre);
	}//Level
	
	/**
	 * Charge un niveau sauvegarde sous forme de fichier texte de chemin
	 * absolu passe en parametres
	 * Le format d'enregistrement doit etre de la forme :
	 * forme x y width height vitesse rotate
	 * */
	public Level(Fenetre fenetre, String path){
		this(fenetre);
		assert(path != null);
		
		nouvellePartie(path);
	}//Level
	
	public Explosion getExplo() {
		return explo;
	}

	public void setExplo(Explosion explo) {
		this.explo = explo;
	}

	/**
	 * Retourne le score
	 * @return score
	 * */
	public Score getScore() {
		return score;
	}
	
	/**
	 * Nouvelle Partie
	 * @param path le fichier a ouvrir
	 * */
	public void nouvellePartie(String path) {
		assert(path != null);
		
		String[] lignes = Loader.readInTab("src/ressources/niveaux/"+path+".txt");//lit les informations contenues dans le fichier
		objects.clear();//nettoyage des objets precedents
		fenetre.clearForms();
		objectsPossible.clear();//nettoyage des objets possibles precedents
		gravityX = gravityY = 0;//suppression de la gravite
		//perdu = false;
		chrome = null;
		ball = null;
		colorIterator = 0;
		colorPossible.clear();//pour acqueillir de nouvelles couleurs
		
		if(lignes.length < TAILLE_ENTETE) {//genere une erreur si l'entete est superieure a lignes
			throw new IllegalStateException("Erreur de taille.");
		}
		
		name = lignes[1];//recupere le nom du niveau
		number = Integer.parseInt(lignes[2]);//recupere le numero du niveau
		type = Type.get(lignes[3]);//recupere le type de niveau
		String[] infosBalle = lignes[4].split(" ");//recupere les infos de la balle
		
		ball = (Ball) FormsFactory.build("Ball", Integer.parseInt(infosBalle[0]), 
				Integer.parseInt(infosBalle[1]), Integer.parseInt(infosBalle[2]), 
				0, Integer.parseInt(infosBalle[3]), 0);//creation de la balle
		
		boolean entete = false;//pour le mode AUTOMATIQUE
		boolean couleurs = false;
		if(type == Type.AUTOMATIQUE) {
			ball.addPoint(ball.getPosX(),ball.getPosY());//position de depart
			entete = true;
			couleurs = true;
		}
		
		for(int i=TAILLE_ENTETE;i<lignes.length;i++) {//pour chaque objet du fichier texte, le cree
			String[] parties = lignes[i].split(" ");//coupe selon les espaces
			if(couleurs) {
				if(parties[0].charAt(0) == '=') {//fin de recuperation des couleurs
					couleurs = false;
					ball.setCouleur(colorPossible.get(0));//couleur de depart
					chrome = (Chrome) FormsFactory.build("CHROME", 50, 50,
							30, 30, 3, 45);//cercle chromatique
					chrome.createChrome(colorPossible);
					fenetre.update(obs, chrome);
					continue;
				}
				if(parties.length < 1 || parties[0].charAt(0) == '#') {//si on a une ligne incorrecte, on l' ignore
					continue;
				}
				//ajout des couleurs possibles pour le niveau
				ajouterCouleur(parties[0]);
			}else if(entete) {//fait l'entete pour le mode AUTOMATIQUE
				if(parties[0].charAt(0) == '=') {//fin d'entete
					entete = false;
					Road road = new Road(0, 0, 30, 30, 4, 4);
					road.createRoad(ball.getPoints());
					objects.add(road);
					continue;
				}
				if(parties.length < 2 || parties[0].charAt(0) == '#') {//si on a une ligne incorrecte, on l' ignore
					continue;
				}
				//nouveau point pour le chemin de la balle
				ball.addPoint(Integer.parseInt(parties[0]),Integer.parseInt(parties[1]));
			}else {
				if(parties.length < 7 || parties[0].charAt(0) == '#') {//si on a une ligne incorrecte, on l' ignore
					continue;
				}
				parties[1] = convertirPourcentage(parties[1], fenetre.getLargeurFenetre());
				parties[2] = convertirPourcentage(parties[2], fenetre.getHauteurFenetre());
				parties[3] = convertirPourcentage(parties[3], fenetre.getLargeurFenetre());
				parties[4] = convertirPourcentage(parties[4], fenetre.getHauteurFenetre());
				
				Form o = FormsFactory.build(parties[0],
						Integer.parseInt(parties[1]),
						Integer.parseInt(parties[2]),
						Integer.parseInt(parties[3]),
						Integer.parseInt(parties[4]),
						Integer.parseInt(parties[5]),
						Integer.parseInt(parties[6]));
				if(o != null){
					objectsPossible.add(o);//cree les objets
				}//if
			}//if
		}//for
		repartirObjets();//choisit les objets a ajouter dans la fenetre
		retaillerObjets();//met a l'echelle
		recalculerObjets();//choisit ou non de les ajouter au thread java fx
		fenetre.update(obs, ball);//ajout de la balle dans les niveaux
		fenetre.restart();//lance le moteur
	}

	/**
	 * Fait la conversion des nombres en pourcentages en vrais nombres
	 * @return String mot le nombre debarrasse de son %
	 * */
	private String convertirPourcentage(String mot, int tailleFenetre) {
		if(mot.endsWith("%")){//convertit les valeurs relatives
			mot = ""+(int)(tailleFenetre * 
					(Double.parseDouble(mot.substring(0, mot.length()-1))/100));
		}
		return mot;
	}
	
	/**
	 * Teste si le niveau est perdu ou non
	 * @return true si le niveau est perdu et false sinon
	 * */
//	public boolean isPerdu() {
//		return perdu;
//	}
	
	public void perdu() {
		System.out.println("perdu");
		//perdu = true;
		//ball.gravityY(0);
		ball = null;
		//ball.setPosY(ball.getPosY()-10);
		gravityYStop();
	}

	/**
	 * Met la vue a jour
	 * */
//	public void update() {
//		recalculerObjets();
////		Platform.runLater(() -> {
////			fenetre.placerBalle();
////		});
//		fenetre.restart();
//	}
//	
	/**
	 * Fait que la balle soit attiree en bas
	 * */
	public void gravityDown() {
		this.gravityY = 1;
	}
	
	/**
	 * Fait que la balle arrete d'etre attiree en x
	 * */
	public void gravityXStop() {
		this.gravityX = 0;
	}
	
	/**
	 * Fait que la balle soit attiree a gauche
	 * */
	public void gravityYStop() {
		this.gravityY = 0;
	}
	
	/**
	 * Fait que la balle soit attiree en haut
	 * */
	public void gravityUp() {
		this.gravityY = -1;
	}
	
	/**
	 * Fait que la balle soit attiree a gauche
	 * */
	public void gravityLeft() {
		this.gravityX = -1;
	}
	
	/**
	 * Fait que la balle soit attiree a droite
	 * */
	public void gravityRight() {
		this.gravityX = 1;
	}
	
	/**
	 * Renvoie le sens de gravitation sur l'axe des X
	 * @return gravityX
	 * */
	public int gravityX() {
		return gravityX;
	}
	
	/**
	 * Renvoie le sens de gravitation sur l'axe des X
	 * @return gravityX
	 * */
	public int gravityY() {
		return gravityY;
	}

	/**
	 * Retourne les obstacles du niveau sous forme de Vector<Form>
	 * @return objects
	 * */
	public Vector<Form> getObjects() {
		return objects;
	}
	
	/**
	 * Retourne les obstacles possibles du niveau sous forme de Vector<Form>
	 * @return objects
	 * */
	public Vector<Form> getObjectsPossible() {
		return objectsPossible;
	}
	
	/**
	 * Retourne la balle
	 * @return ball
	 * */
	public Ball getBall() {
		return ball;
	}

	/**
	 * Retourne le nom du niveau
	 * @return name
	 * */
	public String getName() {
		return name;
	}

	/**
	 * Retourne le numero du niveau
	 * @return number
	 * */
	public int getNumber() {
		return number;
	}

	/**
	 * Retourne le nombre de points marques
	 * @return points
	 * */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Retourne le Type de partie jouee
	 * @return type
	 * */
	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Level [points=" + points + ", score=" + score + ", objects=" + objects + ", name=" + name + ", number=" + number + ", type="
				+ type + "]";
	}

	/**
	 * Renvoie la coordonnee Y du Level
	 * @return coordinateY
	 * */
	public int getCoordinateY() {
		return coordinateY;
	}

	/**
	 * Change la coordonnee Y du Level et recalcule les objets qui doivent ou non s'y trouver
	 * @return coordinateY
	 * */
	public int setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
		recalculerObjets();
		return coordinateY;
	}

	/**
	 * Renvoie la coordonnee X du Level
	 * @return coordinateX
	 * */
	public int getCoordinateX() {
		return coordinateX;
	}

	/**
	 * Change la coordonnee X du Level et recalcule les objets qui doivent ou non s'y trouver
	 * @return coordinateX
	 * */
	public int setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
		recalculerObjets();
		return coordinateX;
	}
	
	/**
	 * Retaille les objets du Level d'apres le ratio tailleCourante / TAILLE_DE_BASE
	 * */
	public void retaillerObjets() {
		scaleX = fenetre.getWidth() / fenetre.getLargeurFenetre();
		scaleY = fenetre.getHeight() / fenetre.getHauteurFenetre();
		transX = (fenetre.getWidth() - fenetre.getLargeurFenetre()) / 2;
		transY = (fenetre.getHeight() - fenetre.getHauteurFenetre()) / 2;
		
		for(Form forme : objects) {
			Group g = forme.getForme();
			g.setTranslateX(transX);
			g.setTranslateY(transY);
			g.setScaleX(scaleX);
			g.setScaleY(scaleY);
		}//for
		if(ball != null) {
			Group g = ball.getForme();
			g.setTranslateX(transX);
			g.setTranslateY(transY);
			g.setScaleX(scaleX);
			g.setScaleY(scaleY);
		}//if
	}//retaillerObjets
	
	/**
	 * Recalcule les objets qui doivent etre ou non presents dans la fenetres afin
	 * d' alleger les calculs.
	 * */
	private void recalculerObjets(){
		if(type.equals(Type.ENDLESS) && isObjectsEnding()) {//niveau sans fin -> verifie pour ajout de nouvelles formes
			ajouterNouvellesFormes();
		}
		for(Form forme : objects) {
			if(!fenetre.isInComponent(forme)) {
				if(fenetre.isInBounds(forme)) {//si l'objet est dans les limites d'affichage
					System.out.println("ajout fenetre -> "+forme);
					//fenetre.placerForme(forme);
					fenetre.update(obs, forme);
				}
			}else {
				if(!fenetre.isInBounds(forme)) {//si l'objet n'est pas dans les limites d'affichage
					System.out.println("retrait fenetre -> "+forme);
					fenetre.retirerForme(forme);
					//fenetre.update(obs, forme);
				}
			}
		}//for
		if(fenetre != null) {
			retaillerObjets();
		}
	}//recalculerObjets
	
	/**
	 * Teste si object est presque vide
	 * */
	private boolean isObjectsEnding() {
		for(Form forme : objects) {
			if(forme.getPosY() < -100) {//faux si il y a des objets non-visibles au dessus
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Choisit de mettre ou non les objets de objectsPossible dans objects
	 * */
	private void repartirObjets() {
		
		if(type.equals(Type.ENDLESS)) {//si on a un niveau sans fin -> place les premiers
			System.out.println("Endless");
			Vector<Form> assuprimer = new Vector<Form>();
			for(Form forme : objectsPossible) {
				if(fenetre.isInBounds(forme)) {//seulement pour les formes visibles au depart
					objects.add(forme);
					assuprimer.add(forme);
				}
			}
			objectsPossible.removeAll(assuprimer);
			System.out.println(objects + "\n---\n"+ objectsPossible);
			if(isObjectsEnding()) {//si objects arrive a la fin, ajoute de nouveaux obstacles
				ajouterNouvellesFormes();
			}
		}else {//autre niveau -> objets places en ordre
			System.out.println("Normal");
			for(Form forme : objectsPossible) {
				objects.add(forme);
			}
		}
	}
	
	/**
	 * Decide quand ajouter une nouvelle forme a l'ensemble des formes
	 * */
	private void ajouterNouvellesFormes() {
		System.out.println("Ajout de nouvelles formes");
		final short NB_FORMES = 1;
		int taillePre = -100;//la limite a ne pas depasser
		
		for(short i=1;i<=NB_FORMES;i++) {
			System.out.println("taille pre ="+taillePre);
			System.out.println("boucle "+i);
			int alea =  (int) (Math.random() * (objectsPossible.size()));
			Form forme = objectsPossible.get(alea);
			taillePre -= (forme.getHeight() + (fenetre.getHauteurFenetre() / 4));
			forme.setPosY(taillePre);
			objects.addElement((Form) forme.clone());
			
			//changecouleur entre les formes
			Form changecouleur = FormsFactory.build("CHANGECOLOR", forme.getPosX(),
					forme.getPosY() + (fenetre.getHauteurFenetre() / 4) ,
					12, 12, 3, 0);
			objects.addElement(changecouleur);
		}
	}
	
	/**
	 * Ajoute une couleur a la liste des couleurs possibles pour le mode AUTOMATIQUE
	 * @param le nom de la couleur a ajouter
	 * */
	private void ajouterCouleur(String couleur) {
		assert(couleur != null);
		
		String coul = couleur.toUpperCase();
		
		/*switch(coul) {
		case "BLUE": colorPossible.add(ColorSelected.BLUE);
		case "ROSE": colorPossible.add(ColorSelected.ROSE);
		case "PURPLE": colorPossible.add(ColorSelected.PURPLE);
		case "YELLOW": colorPossible.add(ColorSelected.YELLOW);
		default : throw new IllegalArgumentException("Mauvaise couleur : "+couleur);
		}*/
		if(coul.equals("BLUE")) {
			colorPossible.add(ColorSelected.BLUE);
		}else if(coul.equals("ROSE")) {
			colorPossible.add(ColorSelected.ROSE);
		}else if(coul.equals("PURPLE")) {
			colorPossible.add(ColorSelected.PURPLE);
		}else if(coul.equals("YELLOW")) {
			colorPossible.add(ColorSelected.YELLOW);
		}else {
			throw new IllegalArgumentException("Mauvaise couleur : "+couleur);
		}
	}

	/**
	 * Renvoie la prochaine couleurPossible
	 * @return Color couleurPossible la prochaine couleur
	 * */
	public Color getNextColor() {
		colorIterator ++;
		if(colorIterator >= colorPossible.size()) {
			colorIterator = 0;
		}
		return colorPossible.get(colorIterator);
	}
	
	/**
	 * Renvoie la precedente couleurPossible
	 * @return Color couleurPossible la precedente couleur
	 * */
	public Color getPreviewsColor() {
		colorIterator --;
		if(colorIterator < 0) {
			colorIterator = (short) (colorPossible.size() - 1);
		}
		return colorPossible.get(colorIterator);
	}

	public Chrome getChrome() {
		return chrome;
	}

	public void addPoints(int i) {
		points += i;
	}

	public void gagne() {
		ball = null;//arrete le jeu
		fenetre.menu();
	}

	public void retirerForme(Form forme) {
		objects.remove(forme);//retire du niveau
		fenetre.retirerForme(forme);//retire de la fenetre
	}
}
