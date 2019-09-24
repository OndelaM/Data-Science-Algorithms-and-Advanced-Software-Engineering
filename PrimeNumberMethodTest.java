package Task11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeNumberMethodTest {

	@Test
	void test() {
		assertTrue(PrimeNumberMethod.isPrime(7));
		assertFalse(PrimeNumberMethod.isPrime(4));
		assertTrue(PrimeNumberMethod.isPrime(2));
		assertFalse(PrimeNumberMethod.isPrime(10));
	}

}
