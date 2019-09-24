package Task11;

public class PrimeNumberMethod {
	
	public static boolean isPrime(int num){
		
		int counter = 0;
		
		for (int i = 1; i <= num; i++) {
			if (num % i ==  0)
				counter ++;
			System.out.println(counter);
		}
		
		if (counter == 2)
			return true;
		else
			return false;
		
	}

}
