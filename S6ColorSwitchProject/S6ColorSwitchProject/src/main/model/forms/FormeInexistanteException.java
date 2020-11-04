package main.model.forms;

class FormeInexistanteException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	FormeInexistanteException(){
		super("Forme incorrecte ou non-implementee dans FormeFactory.");
	}
}
