package main.model.forms;

/**
 * Une fabrique a formes qui suit la logique du Design Pattern Factory
 * */
public class FormsFactory {
	
	private FormsFactory(){}//ininstanciable
	
	public static Form build(String forme, int x, int y, int width, int height, int vitesse, int rotate) {
		String acomparer = forme.toUpperCase();
		switch(acomparer) {
		case "ROUND1":return new Round1(x , y, width, height, vitesse, rotate);//ROUND1
		case "ROUND2" :return new Round2(x , y, width, height, vitesse, rotate);//ROUND2
		case "CARRE" :return new Carre(x, y, width, height, vitesse, rotate);//CARRE
		case "BALL" :return new Ball(x, y, width, height, vitesse, rotate);//BALL
		case "CROIXG" :return new CroixG(x, y, width, height, vitesse, rotate);//CROIXG
		case "CROIXD" :return new CroixD(x, y, width, height, vitesse, rotate);//CROIXD
		case "CHANGECOLOR" :return new ChangeColor(x, y, width, height, vitesse, rotate);//CHANGECOLOR
		case "ETOILE" :return new Etoile(x, y, width, height, vitesse, rotate);//ETOILE
		case "POINT" :return new Point(x, y, width, height, vitesse, rotate);//POINT
		case "OBSTACLEROUND1" :return new ObstacleRound1(x , y, width, height, vitesse, rotate);//OBSTACLEROUND1
		case "LIGNEFIN" :return new LigneFin(x , y, width, height, vitesse, rotate);//LIGNE FIN
		case "MESSAGECOLORSWITCH" :return new MessageColorSwitch(x , y, width, height, vitesse, rotate);//MESSAGECOLORSWITCH
		case "DOIGT" :return new Doigt(x , y, width, height, vitesse, rotate);//DOIGT
		case "CARREDERONDS" :return new CarreDeRonds(x , y, width, height, vitesse, rotate);//DOIGT
		case "RONDDERONDS" :return new RondDeRonds(x , y, width, height, vitesse, rotate);//ROND DE RONDS
		case "RONDDERONDSACCELERE" :return new RondDeRondsAccelere(x , y, width, height, vitesse, rotate);//ROND DE RONDS QUI ACCELERE
		case "BOUTONJOUER" :return new BoutonJouer(x , y, width, height, vitesse, rotate);//BOUTON JOUER
		case "LIGNE" :return new Ligne(x , y, width, height, vitesse, rotate);//LIGNE
		case "ROAD" :return new Road(x , y, width, height, vitesse, rotate);//ROAD
		case "CHROME" :return new Chrome(x , y, width, height, vitesse, rotate);//CHROME
		case "MESSAGESCORE" :return new MessageScore(x , y, width, height, vitesse, rotate);//MESSAGE SCORE
		default:throw new FormeInexistanteException();
		}
	}

	@Override
	public String toString() {
		return "FormsFactory []";
	}
	
}
