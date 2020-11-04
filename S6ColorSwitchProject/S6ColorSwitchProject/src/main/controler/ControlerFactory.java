package main.controler;

import javafx.event.EventHandler;
import javafx.event.EventType;
import main.model.Level;

public class ControlerFactory {

	@SuppressWarnings("unchecked") //le type de retour est correct mais il ne le sait pas.
	public static <T> EventHandler<? super T> build(EventType<? super T> type, Level level, Moteur m) {
		//System.out.println(type.getName());
		switch(type.getName()) {

		case "KEY_TYPED":return (EventHandler<? super T>) new EcouteurToucheClique(level);
		case "KEY_PRESSED":return (EventHandler<? super T>) new EcouteurToucheEnfoncee(level);
		//case "KEY_RELEASED":return (EventHandler<? super T>) new EcouteurToucheRelachee(level);
		case "MOUSE_CLICKED":return (EventHandler<? super T>) new EcouteurSourisSortMenu(m, level);
		case "MOUSE_RELEASED":return (EventHandler<? super T>) new ActionNouvellePartie(level);
		//case "MOUSE_RELEASED":return (EventHandler<? super T>) new EcouteurFenetreRetaillee(level);
		case "ACTION": return (EventHandler<? super T>) new ActionBouton(m, level);
		case "WINDOW_SHOWING":return (EventHandler<? super T>) new EcouteurFenetreOuverte(m);
		case "WINDOW_HIDING":return (EventHandler<? super T>) new EcouteurFenetreFermee(m);
		case "DIALOG_SHOWING":return (EventHandler<? super T>) new EcouteurDialogOuvert();
		//case "EVENT_SHOWING":return (EventHandler<? super T>) new EcouteurMenuOuvert(m);
		//case "EVENT_HIDING":return (EventHandler<? super T>) new EcouteurMenuFerme(m);
		case "MOUSE_ENTERED":return (EventHandler<? super T>) new EcouteurSourisSurMenu(m);
		case "WINDOWS_":return (EventHandler<? super T>) new EcouteurSourisSurMenu(m);
		//case "MOUSE_EXITED":return (EventHandler<? super T>) new EcouteurSourisSortMenu(m);
		default: throw new IllegalArgumentException("type incorrect");
		}
	}
	
	public static <T> EventHandler<? super T> build(EventType<? super T> type, Level level) {
		return build(type, level, null);
	}
	
	public static <T> EventHandler<? super T> build(EventType<? super T> type, Moteur m) {
		return build(type, null, m);
	}
}
