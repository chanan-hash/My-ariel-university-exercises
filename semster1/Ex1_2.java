package semster1;
import java.util.Scanner;
public class Ex1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		// Getting two numbers from the user
		System.out.println("Enter the first number for max prime GCD: ");
		long x = scan.nextLong();

		System.out.println("Enter the second number for max prime GCD:");
		long y = scan.nextLong();

		//measuring the time
		long start = System.nanoTime();
		
		long ans = PGCD(x,y);
		
		if (ans != 1) {	
			System.out.println("\nThe PGCD is: " + ans);
		}

		else {
			System.out.println("We didn't find any PGCD, becuase answer was " + ans);
		}
		
		long end = System.nanoTime();
		double time = (end -start)/1000;
		System.out.println("It took " + time + " mirco seconds:");
		scan.close();
	}



	// A function for checking if a given number is prime
	public static boolean isPrime (long num) {

		if (num == 2) {				// 2 is the first prime number
			return true;
		}

		if (num % 2 == 0) {			//check if the number is even
			return false;
		}

		int i = 3;
		double sqrt = Math.sqrt(num);
		while (i<=sqrt) { 
			if (num % i == 0) { 	// checking if the given number can be divided
				return false;
			}
			else {
				i= i + 2;			// checking only dividing by odd numbers
			}
		}
		return true;				// the loop has finished and the number is prime
	}


	// function to find the prime great common divisor
	public static long PGCD (long x, long y) {
		long min = Math.min(x, y);

		// checking if the two given number are divided by the smallest and if it is prime
		if ((x % min == 0) && (y % min == 0)){
			if (isPrime(min) == true) {
				return min; // this is the PGCD
			}
		}

		long i = min/2; // maybe to init i by sqrt of min

		while (i>1) {

			if ((x % i == 0) && (y % i == 0)) {
				if (isPrime(i) == true) {
					return i;
				}
				i--;
			}
			i = i-1;
		}
		return 1;
	}


}
