package tests;


import org.junit.Test;

//import org.junit.Test;




class allTests {

	@Test
	void testFormsFactory() {
		testFormsFactory t1 = new testFormsFactory();
		t1.testbuild();
	}

	@Test
	void testLevel() {
		testLevel t2 = new testLevel();
		t2.testConstructorDefault();
		t2.testConstructorLoader();
	}

	@Test
	void testLoader() {
		testLoader t3 = new testLoader();
		t3.testread();
		t3.testreadInTab();
	}

	@Test
	void testType() {
		testType t4 = new testType();
		t4.testEnumType();
	}
}
