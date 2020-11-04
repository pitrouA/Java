package main.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.controler.ControlerFactory;
import main.controler.Moteur;
import main.model.ColorSelected;
import main.model.Level;
import main.model.Type;
import main.model.forms.Ball;
import main.model.forms.Explosion;
import main.model.forms.Form;
import main.model.forms.FormsFactory;
import main.model.forms.MessageScore;
import main.view.menubar.ContextualMenu;
import main.view.menubar.ZMenuBar;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Classe qui se charge de la vitrine de l'application.
 * @author PITROU Adrien
 * @version 1.0
 * @since 24/01/18
 * */
public class Fenetre extends Application implements Observer{
	private BorderPane root;
	private final int HAUTEUR_FENETRE = 600;
	private final int LARGEUR_FENETRE = 400;
	private Moteur m;
	private Level level;
	private Pane components;
	private MessageScore score;

	public static void main(String[] args) {
        launch(args);
    }

    /**
     * Retourne la hauteur de base de la fenetre
     * @return HAUTEUR_FENETRE
     * */
    public int getHauteurFenetre() {
    	return HAUTEUR_FENETRE;
    }

    /**
     * Renvoie les composants de la fenetre
     * */
    public Pane getComponents() {
    	return components;
    }
    
    /**
     * Retourne la largeur de base de la fenetre
     * @return LARGEUR_FENETRE
     * */
    public int getLargeurFenetre() {
    	return LARGEUR_FENETRE;
    }
    
    /**
     * Renvoie la largeur courante de root
     * @return hauteur courante de root
     * */
    public double getWidth() {
    	return root.getWidth();
    }
    
    /**
     * Renvoie la hauteur courante de root
     * @return hauteur courante de root
     * */
    public double getHeight() {
    	return root.getHeight();
    }

    /**
     * Renvoie la reference vers l' objet Level
     * @return Level level
     * */
    public Level getLevel() {
    	return level;
    }
    
    /**
     * Place la forme d'indice num du moteur aux coordonnees x et y de cette forme
     * @param components Le panneau dans lequel ajouter la forme
     * @param m le moteur de jeu qui contient l'objet Level et les formes
     * @param num le numero de la forme a ajouter
     * */
    public void placerForme(Form forme) {
    	Node node = forme.getForme();
        node.setLayoutX(forme.getPosX());
        node.setLayoutY(forme.getPosY());
        components.getChildren().add(node);//formeG
    }
    
    @Override
    public void start(Stage primaryStage) {
    	score = (MessageScore) FormsFactory.build("MessageScore",30, 30, 30, 30, 3, 0);
    	
    	//composants
    	components = new Pane();//boite contenant les formes du jeu
    	Background b = new Background(new BackgroundFill(ColorSelected.BLACK,null,null));
		components.setBackground(b);//fond
    	
		//preparation du menu principal
    	this.level = new Level(this);

    	//parametres de l'objet Stage
    	primaryStage.setTitle("Color Switch L3 group : PITROU BARRECH CALVO-FERNANDEZ");
    	primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {//fermeture
            @Override
            public void handle(final WindowEvent event) {
				System.exit(0);
			}
        });

		//Menus
		m = new Moteur(this);
        ZMenuBar menuBar = new ZMenuBar(root, m, level);//la barre de menu
        ContextualMenu cm = new ContextualMenu(m);
        components.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
        	@Override public void handle(MouseEvent e) {
        	if (e.getButton() == MouseButton.SECONDARY)
        	cm.show(components, e.getScreenX(), e.getScreenY());
        	}
        });

        //objet root
        root = new BorderPane();
        root.setCenter(components);
        root.setTop(menuBar);//Barre de Menu
        primaryStage.setScene(new Scene(root, LARGEUR_FENETRE, HAUTEUR_FENETRE));
        root.setPrefSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        
        //ecouteur de touche
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, 
        		ControlerFactory.build(KeyEvent.KEY_PRESSED, level));
        primaryStage.addEventHandler(KeyEvent.KEY_TYPED, 
        		ControlerFactory.build(KeyEvent.KEY_TYPED, level));
        //primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, 
        //		ControlerFactory.build(KeyEvent.KEY_RELEASED, level));
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        		ControlerFactory.build(MouseEvent.MOUSE_CLICKED, level, m));
        //primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, 
        //		ControlerFactory.build(MouseEvent.MOUSE_RELEASED, level, m));
        primaryStage.widthProperty().addListener((obs, oldValue, newValue) -> {
            level.retaillerObjets();
        });
        primaryStage.heightProperty().addListener((obs, oldValue, newValue) -> {
        	level.retaillerObjets();
        });
        
        //icone de jeu
        Image icon=new Image("icon.png");
        primaryStage.getIcons().add(icon);
        
        //m.start();
        menu();
        
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * Teste si la forme passee en parametres est dans les limites de la fenetre ou non
     * @param Form forme la forme a tester
     * @return true si la forme est dans les limites de la fenetre et false sinon
     * */
    public boolean isInBounds(Form forme) {
    	assert(forme != null);
    	
    	return forme.getPosX() < getLargeurFenetre() + 200
				&& forme.getPosX() > - 200
				&& forme.getPosY() < getHauteurFenetre() +400//pour la barre horizontale
				&& forme.getPosY() > - 200;
    }
    
    /**
     * Teste si la forme est deja dans la fenetre ou non
     * @param Form forme la forme a tester
     * @return true si la forme est dans la fenetre et false sinon
     * */
    public boolean isInComponent(Form forme) {
    	return components.getChildren().contains(forme.getForme());
    }
    
    /**
     * Nouvelle parite
     * */
    public void nouvellePartie() {
    	
    	components.getChildren().removeAll(components.getChildren());//enleve les formes actuelles
    	
    	//placement des formes
        for(Form forme:level.getObjects()) {//place les formes
        	if(isInBounds(forme)) {
        		placerForme(forme);
        	}
        }
        
        //placerBalle();
    }

    /**
     * Fait defiler l'ecran selon l'axe des Y
     * @param boolean haut la direction du defilement
     * */
	public void defilerEcranY(boolean haut) {
		int defilement = level.getBall().getSpeed();
		if(haut) {//inversion de direction
			defilement = -defilement;
		}
		
		for(int i=0;i<level.getObjects().size();i++) {//bouge les objets
			Form forme = level.getObjects().get(i);
			forme.setPosY(forme.getPosY()+defilement);
			forme.getForme().setLayoutY(forme.getPosY());
		}
		Ball balle = level.getBall();
		balle.setPosY(balle.getPosY()+defilement);//bouge la balle
		balle.getForme().setLayoutY(balle.getPosY());
		
		if(level.getType() == Type.AUTOMATIQUE) {//repercute le defilement pour le path
			balle.repercuterDefilementY(defilement);
		}
    	
    	level.setCoordinateY(level.getCoordinateY()+defilement);//modifie les coordonnees
	}
	
	/**
     * Fait defiler l'ecran selon l'axe des X
     * @param boolean gauche la direction du defilement
     * */
	public void defilerEcranX(boolean gauche) {
		int defilement = level.getBall().getSpeed();
		if(!gauche) {//inversion de direction
			defilement = -defilement;
		}
		
		for(int i=0;i<level.getObjects().size();i++) {//bouge les objets
			Form forme = level.getObjects().get(i);
			forme.setPosX(forme.getPosX()+defilement);
			forme.getForme().setLayoutX(forme.getPosX());
		}
		Ball balle = level.getBall();
		balle.setPosX(balle.getPosX()+defilement);//bouge la balle
		balle.getForme().setLayoutX(balle.getPosX());
    	
		if(level.getType() == Type.AUTOMATIQUE) {//repercute le defilement pour le path
			balle.repercuterDefilementX(defilement);
		}
		
    	level.setCoordinateX(level.getCoordinateX()+defilement);//modifie les coordonnees
	}
	
	@Override
	public void update(Observable arg0, Object obj) {
		Platform.runLater(() -> {
			placerForme((Form)obj);
		});
	}


	public void retirerForme(Form forme) {
		Platform.runLater(() -> {
			components.getChildren().remove(forme.getForme());
		});
	}

	/**
	 * Efface les formes presentes dans la fenetre
	 * */
	public void clearForms() {
		Platform.runLater(() -> {
			components.getChildren().clear();
		});
	}
	
	/**
     * Menu
     * */
    public void menu() {
    	clearForms();//efface le contenu precedent
    	
    	Form forme = FormsFactory.build("BoutonJouer", getLargeurFenetre()/2 - 75,
    			getHauteurFenetre()/2 - 75,150 , 150, 3, 0);
    	level.getObjects().addElement(forme);
        
    	Group bouton = forme.getForme();
        bouton.setLayoutX(getLargeurFenetre()/2 - 10);
        bouton.setLayoutY(getHauteurFenetre()/2 - 10);
        bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        		ControlerFactory.build(MouseEvent.MOUSE_RELEASED, level, m));
        		
        Form deco1 = (Form)FormsFactory.build("Etoile", getLargeurFenetre()/4,
    			getHauteurFenetre()/4,20 , 20, 5, 0);
        level.getObjects().addElement(deco1);
        
        Form deco2 = (Form)FormsFactory.build("Etoile", 3*getLargeurFenetre()/4,
        		3*getHauteurFenetre()/4,20 , 20, 3, 0);
        level.getObjects().addElement(deco2);
        
        Form deco3 = (Form)FormsFactory.build("Etoile", 3*getLargeurFenetre()/4,
        		getHauteurFenetre()/4,20 , 20, 3, 0);
        level.getObjects().addElement(deco3);

        Platform.runLater(() -> {
        	score.updateScore(level.getPoints());
        	ajouterForme(score.getForme());
        	placerForme(deco1);
        	placerForme(deco2);
        	placerForme(deco3);
        	ajouterForme(bouton);
        	restart();
        });
        
        //assuprimer.getChildren().remove(1);
        //assuprimer.getChildren().add(aremplacer);
        //components = aremplacer;
    }

	private void ajouterForme(Group forme) {
		components.getChildren().add(forme);
	}

	public void restart() {
		m.restart();
	}

//	public void addChrome(Group chrome) {
//		Platform.runLater(() -> {
//        	components.getChildren().add(chrome);
//        });
//	}

	public void updateScore(int score) {
		this.score.updateScore(score);
	}
}



