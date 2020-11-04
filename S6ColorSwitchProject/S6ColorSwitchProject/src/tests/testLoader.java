package tests;

import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.Vector;
import org.junit.Test;
import main.model.Loader;

class testLoader {

	String[] tab = {
			"#####################################niveau de color switch###############################################",
			"niveau 1",
			"1",
			"NORMAL",
			"190 400 4 6 BLUE",
			"##########################################################################################################",
			"Round1 300 300 10 10 2 0"};

	@Test
	void testread() {
		Vector<String> vect = Loader.read("src/ressources/niveaux/niveauTesting.txt");
		Iterator<String> it = vect.iterator();

		for(int i=0;i<tab.length;i++) {
			assertTrue("read error", tab[i].equals(it.next()));
		}
	}

	@Test
	void testreadInTab() {
		String[] tab2 = Loader.readInTab("src/ressources/niveaux/niveauTesting.txt");
		
		for(int i=0;i<tab.length;i++) {
			assertTrue("read error", tab[i].equals(tab2[i]));
		}
	}

	@Test
	void testwrite() {
		Vector<String> vect = new Vector<String>();
		vect.add("1234567890");
		vect.add("erf--!$à");
		vect.add("_");
		Iterator<String> it = vect.iterator();

		Loader.write(vect, "src/ressources/stdout.txt");
		Vector<String> vect2 = Loader.read("src/ressources/stdout.txt");
		Iterator<String> it2 = vect2.iterator();

		assertEquals("size error", vect.size(), vect2.size());

		while(it.hasNext()){
			assertTrue("write error", it.next().equals(it2.next()));
		}
	}

	@Test
	void testwriteInTab() {
		Loader.writeSinceTab(tab, "src/ressources/stdout.txt");
		String[] tab2 = Loader.readInTab("src/ressources/stdout.txt");

		assertEquals("length error", tab.length, tab2.length);

		for(int i=0;i<tab.length;i++) {
			assertTrue("writeInTab error"+i, tab[i].equals(tab2[i]));
		}
	}
}
