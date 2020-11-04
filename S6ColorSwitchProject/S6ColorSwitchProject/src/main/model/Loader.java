package main.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Classe qui propose des services de lecture / ecriture dans des fichiers textes.
 * @author PITROU Adrien
 * @since 20/01/18
 * @version 1.0
 * */
public class Loader{
	
	private Loader(){} //ininstanciable
	
	/**
	 * Lit les donnees d'un fichier dont le chemin absolu est passe
	 * en parametres et les renvoie sous forme de liste de String
	 * @param path le chemin absolu vers le fichier source
	 * @return une liste de String
	 * */
	public static Vector<String> read(String path) {
		assert(path != null);
		
		Vector<String> returned = new Vector<String>();
		Scanner sc = null;
		
		try {
			sc = new Scanner(new BufferedReader(new FileReader(path)));
			while(sc.hasNextLine()){//ajoute les lignes du fichier a la liste
				returned.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
		
		return returned;
	}
	
	/**
	 * Lit les donnees d'un fichier dont le chemin absolu est passe
	 * en parametres et les renvoie sous forme de tableau de String
	 * @param path le chemin absolu vers le fichier source
	 * @return un tableau de String
	 * */
	public static String[] readInTab(String path) {
		assert(path != null);
		
		Vector<String> liste = read(path);
		String[] tab = new String[liste.size()];
		
		for(int i=0;i<liste.size();i++) {//fait passer les lignes dans le tableau
			tab[i] = liste.get(i);
		}
		
		return tab;
 	}
	
	/**
	 * Ecrit les lignes d'une liste de String passee en parametres
	 * dans un fichier dont le chemin absolu est aussi passe en parametres
	 * @param tab la liste de String a sauvegarder
	 * @param path le chemin absolu vers le fichier source
	 * */
	public static void write(Vector<String> tab, String path) {
		assert(path != null);
		assert(tab != null);
		
		BufferedWriter bf = null;
		Iterator<String> it = tab.iterator();
		
		try {
			bf = new BufferedWriter(new FileWriter(path));
			while(it.hasNext()){//ajoute les lignes de la liste au fichier
				bf.write(it.next());
				bf.write("\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bf.flush();
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ecrit les lignes d'une tableau de String passee en parametres
	 * dans un fichier dont le chemin absolu est aussi passe en parametres
	 * @param tab le tableau de String a sauvegarder
	 * @param path le chemin absolu vers le fichier source
	 * */
	public static void writeSinceTab(String[] tab, String path) {
		assert(path != null);
		assert(tab != null);
		
		Vector<String> liste = new Vector<String>();
		
		for(int i=0;i<tab.length;i++) {//fait passer les lignes dans le tableau
			liste.add(tab[i]);
		}
		
		write(liste, path);
 	}
}
