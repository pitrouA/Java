package main.model;

import javafx.scene.paint.Color;

public class ColorSelected{
	public static int i=0;
	public static Color BLACK = Color.rgb(39,39,39);

	public static Color YELLOW = Color.rgb(255,255,0);

	public  static Color PURPLE = Color.rgb(144,13,255);

	public  static Color ROSE = Color.rgb(255,1,129);

	public  static Color BLUE = Color.rgb(50,219,240);

	public  static Color MENU = Color.rgb(90,90,90);

	public  static Color FONT = Color.rgb(90,90,90);

	public  static Color WHITE = Color.rgb(240,240,240);


	public static Color couleuralea(){

		int nombreAleatoire = 1 + (int)(Math.random() * 4);
		switch(nombreAleatoire)
		{
			case 1:
				return YELLOW;
			case 2:
		    	return PURPLE;
			case 3:
				return ROSE;
			case 4:
				return BLUE;
			default:
				return BLUE;
		}
	}
}
