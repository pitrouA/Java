package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.model.Level;
import main.model.Score;
import main.model.Type;
import main.view.Fenetre;

class testLevel {

	@Test
	void testConstructorDefault() {
		Level l = new Level();
		assertTrue("Default constructor error", l.getName().equals("niveau 1") &&
				l.getPoints() == 0 &&
				l.getObjects() != null &&
				l.getObjects().size() == 0 &&
				l.getNumber() == 0 &&
				l.getScore().getClass().equals(Score.class));
	}

	@Test
	void testConstructorLoader() {
		Level l = new Level(new Fenetre2(), "niveauTesting");
		assertTrue("Default constructor loader name", l.getName().equals("niveau 1"));
		assertTrue("Default constructor loader points",l.getPoints() == 0);
		assertTrue("Default constructor loader score",l.getScore().getClass().equals(Score.class));
		assertTrue("Default constructor loader object not null",l.getObjects() != null);
		assertTrue("Default constructor loader object size", l.getObjects().size() == 1);
		assertTrue("Default constructor loader number",l.getNumber() == 1);
		assertTrue("Default constructor loader type",l.getType() == Type.NORMAL);
	}
	
	private class Fenetre2 extends Fenetre{//mox
		Fenetre2(){}
	}
	
	

	/*class LevelTest extends Level{
		LevelTest(){


		}
	}*/
}
