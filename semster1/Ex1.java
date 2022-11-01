package semster1;
import java.util.Scanner;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		// Getting two numbers from the user
		System.out.println("Enter the first number for max prime GCD: ");
		int x = scan.nextInt();

		//checking if the number is to big for Integer class
		while (x>Integer.MAX_VALUE) {
			System.out.println("your number is to big! please enter smaller number: ");
			x = scan.nextInt();
		}

		System.out.println("Enter the second number for max prime GCD:");
		int y = scan.nextInt();

		while (y>Integer.MAX_VALUE) {
			System.out.println("your number is to big please enter smaller number!");
			y = scan.nextInt();
		}

		System.out.println("\nThe PGCD is: " + PGCD(x,y));

		scan.close();
	}



	// A function for checking if a given number is prime
	public static boolean isPrime (int num) {

		if (num == 2) {				// 2 is the first prime number
			return true;
		}
		
		if (num % 2 == 0) {			//check if the number is even
			return false;
		}

		int i = 3;
		while (i<=Math.sqrt(num)) { 
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
	public static int PGCD (int x, int y) {
		int min = Math.min(x, y);

		// checking if the two given number are divided by the smallest and if it is prime
		if ((x % min == 0) && (y % min == 0)){
			if (isPrime(min) == true) {
				return min; // this is the PGCD
			}
		}

		int i = min/2;

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
