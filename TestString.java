package Task11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestString {

	@Test
	void test() {
		String testString = "Hello";
		assertTrue(testString.length() == 5);
		assertTrue(testString.charAt(1) == ('e'));
		assertTrue(testString.substring(1,3).equals("el"));
		assertTrue(testString.indexOf('e') == 1);
		
		
	}

}
