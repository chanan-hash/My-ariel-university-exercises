package semster1;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		// Getting two numbers from the user
		System.out.println("Enter a first number:");
		long num1 = scan.nextLong();
		System.out.println("Enter a second number: ");
		long num2 = scan.nextLong();

		//measuring the time
		long start = System.nanoTime();

		long res = PGCD(num1,num2); // saving the result in a special variable

		if (res !=1) {
			System.out.println("The great prime common divisor is: " + res);
		}
		else{
			System.out.println("Dind't find any pgcd");
		}

		// printing the time
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


	// a function for finding the great prime common divisor
	public static long PGCD(long x, long y) {
		long gcd = x%y;
		// we will use euclid's algorithm so we can use it on big numbers
		while (gcd!=0) {
			// swap
			x = y;
			y = gcd;
			gcd = x%y;
		}
		System.out.println(y);
		// checking if the gcd we've found is prime
		if(isPrime(y)==true) {
			return y;
		}

		// look int the lecture for example

		
		else {
			x = y/2;
			y = x/2;
			while(x!=y) {
				if(x>y) {
					x = x-y;
				}
				else {
					y = y-x;
				}
			}
			System.out.println(y);
		}
		if(isPrime(y)==true) {
			return y;
		}

		// starting loop to check from the gcd till 2 for prime great common divisor
		long pgcd = (y-1)/2;
		while (pgcd > 1) {
			if((x%pgcd == 0)&&(y%pgcd == 0)) {
				if(isPrime(pgcd)==true) {
					return pgcd;
				}
			}
			System.out.println(pgcd);

			pgcd = pgcd-1;
		}	
		return 1;
	}

}
