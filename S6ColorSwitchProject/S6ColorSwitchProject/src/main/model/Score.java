package main.model;

import java.util.Comparator;
import java.util.Vector;

public class Score{
	Vector<Pair<String, Integer>> tabScores;
	
	Score(int size){
		tabScores = new Vector<Pair<String, Integer>>();
		for(int i=0;i<size;i++) {
			tabScores.add(new Pair<String, Integer>("Default", 0));
		}
	}
	
	public String[] getNames(){
		int taille = tabScores.size();
		String[] retour = new String[tabScores.size()];
		
		for(int i=0; i<taille; i++) {
			retour[i] = tabScores.get(i).first();
		}
		
		return retour;
	}
	
	public int[] getScores() {
		int taille = tabScores.size();
		int[] retour = new int[tabScores.size()];
		
		for(int i=0; i<taille; i++) {
			retour[i] = tabScores.get(i).second();
		}
		
		return retour;
	}
	
	public void add(String name, int score) {
		tabScores.add(new Pair<String, Integer>(name, score));
		deleteMin();
	}
	
	private void deleteMin() {
		assert(tabScores.size() > 0);
		
		int indexMin = 0;
		int min = tabScores.get(0).second();
		
		for(int i=1;i<tabScores.size();i++) {
			int val = tabScores.get(i).second();
			if(min > val) {
				indexMin = i;
				min = val;
			}
		}
		tabScores.remove(indexMin);
	}
	
	/**
	 * Renvoie un Vector de Pair trie par ordre decroissant contenant les noms
	 * et scores des joueurs ayant fait les meilleurs resultats.
	 * @return tabScores un tableau de scores trie par ordre decroissant.
	 * */
	public Vector<Pair<String, Integer>> getTab(){
		tabScores.sort(new Comparateur());
		return tabScores;
	}
	
	private class Comparateur implements Comparator<Pair<String, Integer>>{
		@Override
		public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
			return -o1.second().compareTo(o2.second());
		}
	}
}
