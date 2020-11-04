package main.model.forms;

/**
 * Enum pour modeliser le type de forme manipulee.
 * */
public enum Formes{
	ROUND1,
	RECTANGLE,
	DEFAULT;
	
	/**
	 * Change un String en Formes
	 * @param str la forme a obtenir
	 * @return la forme obtenue
	 * */
	public static Formes get(String str){
		str.toUpperCase();//suppression de la casse
		if(str.equals("ROUND1")) {
			return ROUND1;
		}else{
			return DEFAULT;
		}
	}
}
