/**
 * Add a documentation
 ***/

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
		System.out.println("Your numbers for prime great common divisor are: " + num1 +" and, " + num2 );
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

	// finding the gcd of two given numbers by euclid's algorithm
	public static long gcd1 (long n1, long n2) {
		long gcd = n1%n2;
		while (gcd!=0) {
			// swap
			n1 = n2;
			n2 = gcd;
			gcd = n1%n2;
		}
		return n2;
	}

	
	// need to write an explain for this
	//Function to find the prime gcd using the previous functions
	public static long PGCD(long x, long y) {
		long gcd = gcd1(x,y);
		System.out.println("gcd1= " + gcd);
		System.out.println("x= " + x + ", y= " + y);
		long pgcd = 1;


		if(isPrime(gcd)==true) {
			return gcd;
		}
		else {
			while(gcd%2==0) {
				gcd /=2;
				pgcd = 2;
			}
			for (int i = 3; i<Math.sqrt(gcd); i= i+2) {
				while(gcd%i==0) {
					gcd = gcd/i;
					pgcd=i;
				}
			}

			if(gcd>2) {
				pgcd = gcd; 
			}
			return pgcd;
		}

	}

}
