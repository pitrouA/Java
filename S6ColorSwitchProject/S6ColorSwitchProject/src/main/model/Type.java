package main.model;

/**
 * Enum pour modeliser le type de partie associee a un niveau.
 * */
public enum Type{
	NORMAL,
	INVERSE,
	DEUX_AXES,
	AUTOMATIQUE,
	IA,
	ENDLESS;
	
	/**
	 * Change un String en Type
	 * @param str le type a obtenir
	 * @return le type obtenu
	 * */
	public static Type get(String string){
		String str = string.toUpperCase();//suppression de la casse
		switch(str) {
		case "INVERSE": return INVERSE;
		case "DEUX_AXES": return DEUX_AXES;
		case "AUTOMATIQUE": return AUTOMATIQUE;
		case "IA": return IA;
		case "ENDLESS": return ENDLESS;
		default: return NORMAL;
		}
	}
}
