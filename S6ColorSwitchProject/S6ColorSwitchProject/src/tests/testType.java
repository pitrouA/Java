package tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

//import org.junit.Test;


import main.model.Type;

class testType {

	@Test
	void testEnumType() {
		assertEquals("type Normal error",Type.NORMAL, Type.get("Normal"));
		assertEquals("type normal error",Type.NORMAL, Type.get("normal"));
		assertEquals("type NORMAL error",Type.NORMAL, Type.get("NORMAL"));

		assertEquals("type Inverse error",Type.INVERSE, Type.get("Inverse"));
		assertEquals("type Automatique error",Type.AUTOMATIQUE, Type.get("Automatique"));
		assertEquals("type Deux-Axes error",Type.DEUX_AXES, Type.get("Deux_Axes"));
		assertEquals("type IA error",Type.IA, Type.get("IA"));
	}

}
